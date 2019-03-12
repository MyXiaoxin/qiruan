package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class Get {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void getResult(String id,String content) {
		String sql = "update baoxiudan set wx_result=? where id=?";
		conn  = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,content);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
