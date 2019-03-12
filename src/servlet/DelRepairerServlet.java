package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RepairerPager;
import service.DelRepairer;
import service.RepairerPages;

/**
 * Servlet implementation class DelRepairerServlet
 */
@WebServlet("/DelRepairerServlet")
public class DelRepairerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改数据库信息
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("user_id");
		DelRepairer dp = new DelRepairer();
		dp.delRepairer(id);
		//更新页面
		int curp = (int)request.getSession().getAttribute("third");
		RepairerPages rp = new RepairerPages();
		RepairerPager repairerPager = rp.showRepairer(curp);
		HttpSession session = request.getSession();
		session.setAttribute("third", repairerPager.getCurrentPage());
		session.setAttribute("repairerPager", repairerPager);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
