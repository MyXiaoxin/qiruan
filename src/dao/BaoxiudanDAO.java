package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Baoxiudan;
import model.Pager;
import tools.DBUtil;

public class BaoxiudanDAO {
		
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs =null;
	private List<Baoxiudan> list = new ArrayList<Baoxiudan>();
	public Pager showMess(int pageNum) {
		Pager pager = new Pager();
		conn = DBUtil.getConnection();
		Pager result = null;
		String sql ="select * from baoxiudan limit " + ((pageNum-1) * 2) + "," +2;//每页显示2条记录
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String str = null;
			int num = 0;
			while(rs.next()) {
					Baoxiudan bxd = new Baoxiudan();
					if ((str=rs.getString("bx_stu"))!=null) {
						bxd.setBx_stu(str);
					}
					if ((str=rs.getString("bx_time"))!=null) {
						bxd.setBx_time(str);
					}
					if ((num=rs.getInt("id"))!=0) {
						bxd.setId(num);
					}
					if ((str=rs.getString("description"))!=null) {
						bxd.setDescription(str);
					}
					if ((str=rs.getString("place"))!=null) {
						bxd.setPlace(str);
					}
					if ((num=rs.getInt("status"))!=0) {
						bxd.setStatus(num);
					}
					if ((str=rs.getString("thing"))!=null) {
						bxd.setThing(str);
					}
					if ((num=rs.getInt("wx_person_id"))!=0) {
						bxd.setWx_person_id(num);
						bxd.setWx_person(IdParseString(num));
					}
					if ((str=rs.getString("wx_result"))!=null) {
						bxd.setWx_result(str);
					}
					if ((str=rs.getString("wx_time"))!=null) {
						bxd.setWx_time(str);
					}
					
					list.add(bxd);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		String sql1 = "select count(id) total from baoxiudan";
		int num = 0;
		try {
			rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				num = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int total = num / 2;
		if(num%2!=0) {
			total++;
		}
		return new Pager(total,pageNum,list);
	}
		
	
	
	


	public String IdParseString(int id){
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		String sql = "select * from weixiu where id="+id;
		String name =null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				name = rs.getString("name");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return name;		
	}

	

}
