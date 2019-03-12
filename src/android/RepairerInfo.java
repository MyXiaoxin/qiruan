package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.User2;

@WebServlet("/RepairerInfo")
public class RepairerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RepairerInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		User2 user = new User2();
		user.setId("201602");
		user.setWorker_phone("17864185411");
		user.setUsername("李师傅");
		user.setWorker_dept("明德物业");
		user.setWorker_sex("男");
		PrintWriter pw = response.getWriter();
		pw.print(new JSONObject(user));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
