package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import tools.DBUtil;

public class AddUserDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void AddUser(User user) {
		
		String id = user.getId();
		String password = user.getPasswd();
		String username = user.getUsername();
		String sql = "insert into user(id,password,username) values(?,?,?)";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
