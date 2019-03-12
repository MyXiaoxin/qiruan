package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		/*String thing  = request.getParameter("type");
		String id = request.getParameter("id");
		String description = request.getParameter("descriable");
		String num = request.getParameter("phone");
		String address = request.getParameter("location");
		
		private String title;
		private String time;
		private String content;*/

		/*HttpServletResponse responses= ServletActionContext.getResponse();
		PrintWriter writer=responses.getWriter();
		writer.write("success!!!!");
		*/
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
