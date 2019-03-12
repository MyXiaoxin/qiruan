package service;

import dao.DelBaoxiudanDAO;

public class DelBaoxiu {
	public void del(String id) {
		DelBaoxiudanDAO dao = new DelBaoxiudanDAO();
		dao.delBaoxiudan(id);
	}
	

}
