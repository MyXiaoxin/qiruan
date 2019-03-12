package test;

import dao.AddRepairDAO;
import entity.Baoxiudan;

public class Test05 {
	public static void main(String[] args) {
		String bx_stu = "account";
		String place = "location";
		String thing = "thing";
		String description = "situation";
		Baoxiudan bxd = new Baoxiudan();
		bxd.setBx_stu(bx_stu);
		bxd.setDescription(description);
		bxd.setPlace(place);
		bxd.setThing(thing);
		AddRepairDAO ad = new AddRepairDAO();
		ad.Add(bxd);
	}
}
