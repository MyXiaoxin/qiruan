package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Baoxiudan;
import tools.DBUtil;

public class UpdateFormDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	public void updateForm(Baoxiudan bxd) {
		conn = DBUtil.getConnection();
		String sql = "update baoxiudan set wx_person_id = ?,wx_result=?,status=? where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bxd.getWx_person_id());
			ps.setString(2, bxd.getWx_result());
			ps.setInt(3, bxd.getStatus());
			ps.setInt(4, bxd.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
