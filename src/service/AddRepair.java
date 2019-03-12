package service;

import dao.AddRepairDAO;
import entity.Baoxiudan;

public class AddRepair {
	public void Add(Baoxiudan bxd) {
		AddRepairDAO dao = new AddRepairDAO();
		dao.Add(bxd);
	}

}
