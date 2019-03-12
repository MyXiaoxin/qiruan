package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pager;
import model.RepairerPager;
import model.UserPager;
import service.JdbcSql;
import service.RepairerPages;
import service.ShowUser;
import tools.DBUtil;

public class LoginServlet extends HttpServlet {
	private Connection conn = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		conn = DBUtil.getConnection();
		String sql = "select * from admin where username = ? and password= ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String account = req.getParameter("account");
		String paw = req.getParameter("password");
		//初始化分页信息
		try {
			if(account!=null&&paw!=null) {
				ps = conn.prepareStatement(sql);
				ps.setString(1, req.getParameter("account"));
				ps.setString(2, paw);
				rs = ps.executeQuery();
	
				if (rs.next()) {
					JdbcSql jdbcsql = new JdbcSql();
					Pager pages = jdbcsql.showMess(1);
					ShowUser showUser = new ShowUser();
					UserPager userPager = showUser.showUser(1);
					RepairerPages rp = new RepairerPages();
					RepairerPager repairerPager = rp.showRepairer(1);					
					HttpSession session = req.getSession();
					session.setAttribute("username", account);
					session.setAttribute("pages", pages);
					session.setAttribute("first", 1);
					session.setAttribute("userPager",userPager);
					session.setAttribute("second", 1);
					session.setAttribute("repairerPager", repairerPager);
					session.setAttribute("third", 1);
					//req.getRequestDispatcher("main.jsp").forward(req, resp);
					resp.sendRedirect("main.jsp");
				}else {
					resp.sendRedirect("main.jsp");
					//req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
			}else {
				resp.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
		}
	}
}
