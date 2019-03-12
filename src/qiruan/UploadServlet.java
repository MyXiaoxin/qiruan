package qiruan;

import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;


@WebServlet("/UploadServlet")
@MultipartConfig(location="C:\\")
public class UploadServlet extends HttpServlet {
	public static String generateGUID() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(now);
		return str+System.nanoTime();
	}
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("file");
		response.setContentType("text/html;charset=utf-8");
		
		if(part!=null) {
			response.getWriter().println("123456");
			response.getWriter().println(this.getServletContext().getRealPath("/"));
			ApplicationPart aaa = (ApplicationPart)part;
			String str = aaa.getFilename();
			int id = str.lastIndexOf(".")+1;
			String realName = str.substring(id,str.length());
			part.write(this.getServletContext().getRealPath("/")+"/images/"+this.generateGUID()+"."+realName);
		}
	}

}
