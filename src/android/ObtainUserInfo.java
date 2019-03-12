package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import AndroidDAO.ObtainUserInfoDAO;
import model.User;

@WebServlet("/ObtainUserInfo")
public class ObtainUserInfo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		if(id!=null) {
			ObtainUserInfoDAO dao = new ObtainUserInfoDAO();
			User user = dao.obtainUser(id);
			PrintWriter pw = response.getWriter();
			pw.print(new JSONObject(user));
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
