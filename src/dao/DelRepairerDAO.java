package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class DelRepairerDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void delRepairer(String id) {
		String sql = "delete from weixiu where id=?";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
