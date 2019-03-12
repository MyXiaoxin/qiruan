package service;

import dao.BaoxiudanDAO;
import model.Pager;

public class JdbcSql {
	
	public Pager showMess(int pageNum) {
		
		BaoxiudanDAO dao = new BaoxiudanDAO();
		Pager result = dao.showMess(pageNum);
		return result;
	}

}
