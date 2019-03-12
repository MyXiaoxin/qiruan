package android;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class CommentServletDAO {
	private String url ="";
	private int star =0;
	private String neirong ="";
	private String wxd_id =null;
	
	private Connection conn = null;
	private PreparedStatement ps =null;
	public void comment(String url,int star,String neirong,String wxd_id) {
		String sql = "insert into comment (star,weixiudan_id,neirong,pic_url)values(?,?,?,?)";
		conn = DBUtil.getConnection();
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, star);
			ps.setString(2, wxd_id);
			ps.setString(3, neirong);
			ps.setString(4, url);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
