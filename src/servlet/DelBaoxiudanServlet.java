package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pager;
import service.DelBaoxiu;
import service.JdbcSql;

@WebServlet("/DelBaoxiudanServlet")
public class DelBaoxiudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		DelBaoxiu bxd = new DelBaoxiu();
		bxd.del(id);
		response.getWriter().println("删除成功");
		//更新页面信息
		//更新页面
		HttpSession session = request.getSession();
		int curp = (int)session.getAttribute("first");
		JdbcSql jdbc = new JdbcSql();
		Pager pages = jdbc.showMess(curp);
		session.setAttribute("pages",pages);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
