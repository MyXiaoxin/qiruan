package AndroidDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Comment;
import tools.DBUtil;

public class AddCommentDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	public void addComment(Comment comment) {
		String sql = "insert into comment(star,weixiudan_id,neirong)values(?,?,?)";
		conn = DBUtil.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, comment.getStar());
			psmt.setInt(2, comment.getWxd_id());
			psmt.setString(3, comment.getComment());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
