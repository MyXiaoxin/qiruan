package androidtest;

import org.json.JSONArray;
import org.json.JSONObject;

import AndroidDAO.ObtainRecord;
import entity.Records;

public class Test005 {
	public static void main(String[] args) {
		ObtainRecord dao = new ObtainRecord();
		Records records = dao.obtaibRecord("201601");
		System.out.println(new JSONObject(records));
	}

}
