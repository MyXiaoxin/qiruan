
package service;

import dao.UpdateRepairerDAO;
import model.Repairer;

public class UpdateRepairerService {
	public void updateRepairer(Repairer repairer) {
		UpdateRepairerDAO dao = new UpdateRepairerDAO();
		dao.updateRepairer(repairer);
	}
	
}
