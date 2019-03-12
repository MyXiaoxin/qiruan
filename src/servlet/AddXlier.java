package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RepairerPager;
import service.AddXlierService;
import service.RepairerPages;

@WebServlet("/AddXlier")
public class AddXlier extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//更改数据库中信息
		String username = req.getParameter("username");
		AddXlierService ax = new AddXlierService();
		ax.addXlier(username);
		//更新页面数据
		int curp = (int)req.getSession().getAttribute("third");
		RepairerPages rp = new RepairerPages();
		RepairerPager repairerPager = rp.showRepairer(curp);
		HttpSession session = req.getSession();
		session.setAttribute("third", repairerPager.getCurrentPage());
		session.setAttribute("repairerPager", repairerPager);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
