package service;

import dao.UpdateUserDAO;
import model.User;

public class UpdateUser {
	public void updateUser(User user) {
		UpdateUserDAO dao = new UpdateUserDAO();
		dao.updateUser(user);
	}

}
