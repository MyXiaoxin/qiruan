package service;

import dao.UpdateFormDAO;
import entity.Baoxiudan;

public class UpdateForm {
	public void updateForm(Baoxiudan bxd) {
		UpdateFormDAO dao = new UpdateFormDAO();
		dao.updateForm(bxd);
	}
}
