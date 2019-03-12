package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class UpdateNameDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void UpdateName(String id,String name) {
		String sql = "update user set username =? where id=?";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
