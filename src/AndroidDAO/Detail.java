package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.WeixiuDetailModel;
import tools.DBUtil;

public class Detail {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	public WeixiuDetailModel detail(String id) {
		WeixiuDetailModel model = new WeixiuDetailModel();
		String sql = "select wx_person_id,status from baoxiudan where id=?";
		String sql0 = "select name,phone from weixiu where id =?";
		conn = DBUtil.getConnection();
		String str = "";
		String str1="";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if((str=rs.getString("wx_person_id"))==null) {
					return null;
				}
				if((str1=rs.getString("status"))!=null) {
					if("3".equals(str1)) {
						model.setStatus("已完成");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps = conn.prepareStatement(sql0);
			ps.setString(1, str);
			rs = ps.executeQuery();
			while(rs.next()) {
				if((str=rs.getString("name"))!=null) {
					model.setWeixiuName(str);
				}
				if((str=rs.getString("phone"))!=null) {
					model.setWeixiuPhone(str);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
		
	}
	
}
