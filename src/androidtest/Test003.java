package androidtest;

import AndroidDAO.AddCommentDAO;
import entity.Comment;

public class Test003 {
	public static void main(String[] args) {
		AddCommentDAO dao = new AddCommentDAO();
		Comment comm = new Comment();
		comm.setStar("2.0");
		comm.setComment("修的真不错");
		comm.setWxd_id(1);
		dao.addComment(comm);
	}

}
