package androidtest;

import org.json.JSONObject;

import AndroidDAO.Detail;
import model.WeixiuDetailModel;

public class Test004 {

	public static void main(String[] args) {
		Detail detail = new Detail();
		WeixiuDetailModel model = detail.detail("1");
		System.out.println(new JSONObject(model));
	}

}
