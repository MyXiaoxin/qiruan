package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserPager;
import service.ShowUser;
import service.UpdateUser;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"  "+password);
		String id = request.getParameter("id");
		User user = new User();
		user.setId(id);
		user.setPasswd(password);
		user.setUsername(username);
		UpdateUser uu = new UpdateUser();
		uu.updateUser(user);
		
		//更新页面数据
		HttpSession session = request.getSession();
		int curp = (int)session.getAttribute("second");
		ShowUser showUser = new ShowUser();
		UserPager userPager = showUser.showUser(curp);
		session.setAttribute("userPager", userPager);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
