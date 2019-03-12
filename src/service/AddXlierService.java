package service;

import dao.AddXlierDAO;

public class AddXlierService {
	public void addXlier(String username) {
		AddXlierDAO dao = new AddXlierDAO();
		dao.addXlier(username);
	}
}
