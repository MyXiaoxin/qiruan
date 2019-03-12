package service;

import dao.UserDAO;
import model.UserPager;

public class ShowUser {
	public UserPager showUser(int pageNum) {
		UserDAO userDAO = new UserDAO();
		UserPager userPager = userDAO.showUser(pageNum);
		return userPager;
	}
}
