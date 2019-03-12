package android;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import AndroidDAO.AddCommentDAO;
import dao.AddRepairDAO;
import entity.Baoxiudan;
import entity.Comment;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,String> map = new HashMap<String,String>();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw= response.getWriter();
		String message = "";
		String pre = "";
		try{
			DiskFileItemFactory dff = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setHeaderEncoding("utf-8");
			List<FileItem> items = (List<FileItem>)sfu.parseRequest(request);
			// 获取上传字段
			for(FileItem fileItem : items) {
				if(!fileItem.isFormField()){
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
					try {
						fileItem.write(new File(storeDirectory, filename));
						String filePath = "/files/images" + "/" + filename;
						pre = "http:101.200.55.171:8080/qiruan";
						message = pre+filePath;
						map.put("url", message);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					String name = new String(fileItem.getFieldName().getBytes("iso-8859-1"),"utf-8");
					String value = new String(fileItem.getString().getBytes("iso-8859-1"),"utf-8");
					map.put(name, value);
				}
			}
					
				} catch (Exception e) {
					message = "上传图片失败";
				} finally {
					CommentServletDAO dao = new CommentServletDAO();
					dao.comment(map.get("evluation"), Integer.parseInt(map.get("favNum")), map.get("evluation"), map.get("id"));
				}	
		pw.print(200);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
