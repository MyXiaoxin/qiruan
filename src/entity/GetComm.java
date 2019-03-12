package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tools.DBUtil;

public class GetComm {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public String getComm(String id) {
		String sql = "select neirong from comment where weixiudan_id=?";
		String str ="";
		conn  = DBUtil.getConnection();
		try {
			ps  = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				if((str=rs.getString("neirong"))!=null){
					System.out.println(str);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return str;
	}

}