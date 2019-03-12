package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import tools.DBUtil;

public class UpdateUserDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	public void updateUser(User user) {
		String sql = "update user set password=?,username=? where id=?";
		con = DBUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,user.getPasswd());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
