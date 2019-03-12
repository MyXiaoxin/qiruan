package service;

import dao.DelUserDAO;

public class DelUser {
	public void delUser(String id) {
		DelUserDAO dao = new DelUserDAO();
		dao.delUserDAO(id);
	}

}
