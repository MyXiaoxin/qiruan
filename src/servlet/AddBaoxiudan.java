package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Baoxiudan;
import model.Pager;
import service.AddRepair;
import service.JdbcSql;

@WebServlet("/AddBaoxiudan")
public class AddBaoxiudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//更新数据库中的信息
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String bx_stu = request.getParameter("account");
		String place = request.getParameter("location");
		String thing = request.getParameter("thing");
		String description = request.getParameter("situation");
		Baoxiudan bxd = new Baoxiudan();
		bxd.setBx_stu(bx_stu);
		bxd.setDescription(description);
		bxd.setPlace(place);
		bxd.setThing(thing);
		AddRepair add = new AddRepair();
		add.Add(bxd);
		response.getWriter().println("成功添加信息！");
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
