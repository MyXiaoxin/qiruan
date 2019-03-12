package test;

import dao.AddUserDAO;
import dao.UpdateFormDAO;
import entity.Baoxiudan;

public class Test08 {
	public static void main(String[] args) {
		Baoxiudan bxd = new Baoxiudan();
		bxd.setId(10);
		bxd.setStatus(2);
		bxd.setWx_result("goog");
		bxd.setWx_person_id(1);
		UpdateFormDAO dao = new UpdateFormDAO();
		dao.updateForm(bxd);
	}

}
