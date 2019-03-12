package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import entity.Baoxiudan;
import entity.RepairPerson;
import tools.DBUtil;

public class RepairForm {
	
	private Connection conn = DBUtil.getConnection();
	private List<Baoxiudan> list = new ArrayList<Baoxiudan>();
	private List<RepairPerson> list1 = new ArrayList<RepairPerson>();
	public List<Baoxiudan> repairForm() {
		ResultSet rs = null;
		String sql = "select * from baoxiudan";
		PreparedStatement ps = null;
		try {
			Statement stmt = conn.createStatement();
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
				conn.close();
				rs.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}
	
	
	public List<RepairPerson> repairPerson(){
		ResultSet rs = null;
		String sql = "select * from weixiu";
		PreparedStatement ps = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String str = null;
			int num = 0;
			while(rs.next()) {
				RepairPerson rp = new RepairPerson();
				if ((str=rs.getString("name"))!=null) {
					rp.setName(str);
				}
				if((str=rs.getString("id"))!=null) {
					
					rp.setId(Integer.parseInt(str));
				}
				list1.add(rp);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			return list1;
			//关闭资源
		}

	}
	
	
	
	public String IdParseString(int id) {
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
