package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Repairer;
import tools.DBUtil;

public class UpdateRepairerDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void updateRepairer(Repairer repair) {
		String sql = "update weixiu set name = ?where id =?";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, repair.getName());
			ps.setInt(2, repair.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
