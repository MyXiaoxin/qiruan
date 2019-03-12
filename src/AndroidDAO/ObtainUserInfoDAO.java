package AndroidDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

import model.User;
import tools.DBUtil;

public class ObtainUserInfoDAO {
	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private User user;
	public User obtainUser(String id) {
		user = new User();
		String sql = "select * from user where id="+id;
		conn = DBUtil.getConnection();
		String str = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if((str=rs.getString("username")) != null) {
					user.setUsername(str);
				}
				if((str=rs.getString("user_dept")) != null) {
					user.setUser_dept(str);
				}
				if((str=rs.getString("user_sex")) != null) {
					user.setUser_sex(str);
				}
				if((str=rs.getString("id")) != null) {
					user.setId(str);
				}
				if((str=rs.getString("tx_url")) != null) {
					user.setTx_url(str);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
