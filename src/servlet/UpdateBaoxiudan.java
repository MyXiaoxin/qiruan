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
import service.JdbcSql;
import service.UpdateForm;

@WebServlet("/UpdateBaoxiudan")
public class UpdateBaoxiudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String person = request.getParameter("c");
		String result = request.getParameter("result");
		result = new String(result.getBytes("iso-8859-1"),"utf-8");
		String statu = request.getParameter("statu");
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		int personId = Integer.parseInt(person);
		int status = Integer.parseInt(statu);
		int id0 = Integer.parseInt(id);
		Baoxiudan bxd = new Baoxiudan();
		bxd.setWx_person_id(personId);
		bxd.setWx_result(result);
		bxd.setStatus(status);
		bxd.setId(id0);
		UpdateForm uf = new UpdateForm();
		uf.updateForm(bxd);
		response.getWriter().write("修改成功");
		//更新页面中的数据
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
