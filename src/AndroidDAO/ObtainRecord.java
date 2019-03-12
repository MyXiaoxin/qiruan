package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Baoxiudan;
import entity.Record;
import entity.Records;
import tools.DBUtil;

public class ObtainRecord {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private List<Record> list = new ArrayList<Record>();
	public Records obtaibRecord(String id){
		String sql = "select * from baoxiudan where wx_person_id = ?";
		String str = "";
		int num=0;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Record record = new Record();
				if ((str=rs.getString("thing"))!=null) {
					record.setTypeText(str);
				}
				if ((num=rs.getInt("status"))!=0) {
					if(num==0) {
						str="未处理";
					}else if(num==1) {
						str="未受理";
					}else if(num==2) {
						str="处理中";
					}else if(num==3) {
						str="已完成";
					}
					record.setState(str);
				}
				if ((str=rs.getString("description"))!=null) {
					record.setDetailsText(str);
				}
				if ((str=rs.getString("bx_time"))!=null) {
					record.setTime(str);
				}
				if ((str=rs.getString("tx_pic_url"))!=null) {
					record.setImageUrl(str);
				}
				if ((num=rs.getInt("id"))!=0) {
					record.setId(num);
				}
				list.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
		}
		Records records = new Records();
		records.setList(list);
		return records;
	}
}
