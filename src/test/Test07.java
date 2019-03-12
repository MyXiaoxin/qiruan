package test;

import dao.AddUserDAO;
import model.User;

public class Test07 {
	public static void main(String[] args) {
		User user = new User();
		user.setId("00000");
		user.setPasswd("000000");
		user.setUsername("小风");
		AddUserDAO dao = new AddUserDAO();
		dao.AddUser(user);
	}

}
