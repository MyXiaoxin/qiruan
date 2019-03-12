package androidtest;

import org.json.JSONObject;

import AndroidDAO.ObtainUserInfoDAO;
import model.User;

public class Test002 {

	public static void main(String[] args) {
		ObtainUserInfoDAO dao = new ObtainUserInfoDAO();
		User user = dao.obtainUser("201601");
		System.out.println(new JSONObject(user));
	}

}
