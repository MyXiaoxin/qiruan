package android;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AndroidDAO.UpdateSexDAO;


@WebServlet("/UpdateSexServlet")
public class UpdateSexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//String sex = request.getParameter("sex");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		System.out.print(sex);
		if(id!=null&&sex!=null) {
			UpdateSexDAO dao  = new UpdateSexDAO();
			dao.updateSex(id, sex);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
