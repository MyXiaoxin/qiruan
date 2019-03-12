package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import AndroidDAO.ObtainRecord;
import entity.Baoxiudan;
import entity.Record;
import entity.Records;

@WebServlet("/ObtainRecordServlet")
public class ObtainRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Baoxiudan> list = new ArrayList<Baoxiudan>();	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		PrintWriter pw = response.getWriter();
		ObtainRecord dao = new ObtainRecord();
		Records records = dao.obtaibRecord("201602");
		pw.print(new JSONObject(records));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
