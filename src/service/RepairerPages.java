package service;

import dao.RepairerPagesDAO;
import model.RepairerPager;

public class RepairerPages {
	private RepairerPager rp =null;
	public RepairerPager showRepairer(int num) {
		RepairerPagesDAO dao = new RepairerPagesDAO();
		rp = dao.repairerPages(num);
		return rp;
	}

}
