package test;

import dao.UpdateUserDAO;
import model.User;

public class Test09 {
	public static void main(String[] args) {
		User user = new User();
		user.setId("00000");
		user.setUsername("username");
		user.setPasswd("password");
		
		UpdateUserDAO dao = new UpdateUserDAO();
		dao.updateUser(user);
	}

}
