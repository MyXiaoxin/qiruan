package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AndroidDAO.Denglu0;
import AndroidDAO.Denglu1;

@WebServlet("/Denglu2")
public class Denglu2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"    "+password);
		PrintWriter pw = response.getWriter();
		Denglu0 dl = new Denglu0();
		boolean bool= dl.denglu(username, password);
		if(bool) {
			pw.print("OK");
		}else {
			pw.print("ERROR");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
