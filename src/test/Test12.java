package test;

import model.Repairer;
import service.UpdateRepairerService;

public class Test12 {
	public static void main(String[] args) {
		UpdateRepairerService service = new UpdateRepairerService();
		Repairer er = new Repairer();
		er.setId(7);
		er.setName("name");
		service.updateRepairer(er);
	}

}
