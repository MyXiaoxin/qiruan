package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.UserPager;
import tools.DBUtil;

public class UserDAO {
	private List<User> list = new ArrayList<User>();
	private UserPager userPage = new UserPager();
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public UserPager showUser(int pageNum) {
		conn = DBUtil.getConnection();
		String sql ="select * from user limit " + ((pageNum-1) * 2) + "," +2;//每页显示2条记录
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String str=null;
			int num = 0;
			while(rs.next()) {
				User user = new User();
				if((str=rs.getString("id"))!=null) {
					user.setId(str);
				}
				if((str=rs.getString("password"))!=null) {
					user.setPasswd(str);
				}
				if((str=rs.getString("username"))!=null) {
					user.setUsername(str);
				}
				if((str=rs.getString("tx_url"))!=null) {
					user.setTx_url(str);
				}
				if((str=rs.getString("user_sex"))!=null) {
					user.setUser_sex(str);
				}
				if((str=rs.getString("user_birth"))!=null) {
					user.setUser_birth(str);
				}
				if((str=rs.getString("user_dept"))!=null) {
					user.setUser_dept(str);
				}
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String sql1 = "select count(id) total from user";
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
		return new UserPager(pageNum,total,list);
	}
	
	

}
