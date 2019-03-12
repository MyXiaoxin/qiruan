package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class AddXlierDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void addXlier(String username) {
		String sql = "insert into weixiu(name) values (?)";
		conn = DBUtil.getConnection();
		try {
			ps =  conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
