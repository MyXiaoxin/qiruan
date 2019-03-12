package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RepairerPager;
import service.RepairerPages;

@WebServlet("/RepairerFenyeServlet")
public class RepairerFenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String num = request.getParameter("num");
		int number = Integer.parseInt(num);
		RepairerPages rp = new RepairerPages();
		RepairerPager repairerPager = rp.showRepairer(number);
		HttpSession session = request.getSession();
		session.setAttribute("third", repairerPager.getCurrentPage());
		session.setAttribute("repairerPager", repairerPager);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
