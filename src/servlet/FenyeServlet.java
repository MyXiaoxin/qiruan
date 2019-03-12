package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pager;
import service.JdbcSql;


@WebServlet("/FenyeServlet")
public class FenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JdbcSql jdbcSql = new JdbcSql(); 
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int pa = Integer.parseInt(request.getParameter("current"));
		HttpSession session = request.getSession();
		Pager pages = jdbcSql.showMess(pa);		
		session.setAttribute("first", pages.getCurrentPage());
		session.setAttribute("pages",pages);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
