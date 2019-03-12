package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class UpdateSexDAO {
	private Connection conn = null;
	private PreparedStatement pst = null;
	public void updateSex(String id,String sex) {
		String sql = "update user set user_sex=? where id=?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, sex);
			pst.setString(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
