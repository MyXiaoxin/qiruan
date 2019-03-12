package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UpdateRepairerDAO;
import model.Repairer;
import model.RepairerPager;
import service.RepairerPages;

@WebServlet("/UpdateRepairerServlet")
public class UpdateRepairerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		int id0 = Integer.parseInt(id);
		Repairer er = new Repairer();
		er.setName(username);
		er.setId(id0);
		UpdateRepairerDAO dao = new UpdateRepairerDAO();
		dao.updateRepairer(er);
		//修改完数据库中的信息，然后更新页面
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
