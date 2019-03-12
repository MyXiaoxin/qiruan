package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class DelBaoxiudanDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;

	public void delBaoxiudan(String id) {
		conn = DBUtil.getConnection();
		String sql = "delete from baoxiudan where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,id );
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
