package service;

import dao.AddUserDAO;
import model.User;

public class AddUser {
	public void AddUser(User user) {
		AddUserDAO dao = new AddUserDAO();
		dao.AddUser(user);
	}

}
