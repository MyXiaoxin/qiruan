package android;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/UploadImageServlet")
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		uploadImage(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	private void uploadImage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Jinru");
		String message = "";
		String url = "";
		try{
			DiskFileItemFactory dff = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dff);
			List<FileItem> list = sfu.parseRequest(request);
			// 获取上传字段
			
			for(FileItem fileItem : list){
				if(fileItem.isFormField()){
					String name = fileItem.getFieldName();
					String value = fileItem.getString();
					System.out.println(name+value);
				}
				
			// 更改文件名为唯一的
			String filename = fileItem.getName();
			if (filename != null) {
				filename = IdGenertor.generateGUID() + "." + FilenameUtils.getExtension(filename);
			}
			// 生成存储路径
			String storeDirectory = getServletContext().getRealPath("/files/images");
			System.out.println(storeDirectory);
			File file = new File(storeDirectory);
			if (!file.exists()) {
				file.mkdir();
			}
			// 处理文件的上传
			try {
				fileItem.write(new File(storeDirectory, filename));
				
				String filePath = "/files/images" + "/" + filename;
				String prex = "http://101.200.55.171:8080/qiruan";
				url = prex+filePath;
				message = filePath;
			} catch (Exception e) {
				message = "上传图片失败";
			} finally {
			response.getWriter().write(message);
			System.out.println("UploadImageServlet"+url);
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
