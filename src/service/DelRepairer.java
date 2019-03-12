package service;

import dao.DelRepairerDAO;

public class DelRepairer {
	public void delRepairer(String id) {
		DelRepairerDAO dao = new DelRepairerDAO();
		dao.delRepairer(id);
	}
}
