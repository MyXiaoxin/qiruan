package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Baoxiudan;
import tools.DBUtil;

public class AddRepairDAO {
	private String bx_stu;
	private String place;
	private String thing;
	private String description;
	private String phone;
	private String pic_url;
	private String date1;
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement ps= null;
	private int returnId;
	
	public int Add(Baoxiudan bxd) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date1 = sdf.format(date);
		bx_stu = bxd.getBx_stu();
		place = bxd.getPlace();
		thing = bxd.getThing();
		description = bxd.getDescription();
		phone = bxd.getPhone();
		pic_url = bxd.getTx_pic_url();
		String sql = "insert into baoxiudan(bx_stu,place,thing,description,bx_time,phone,tx_pic_url)values (?,?,?,?,?,?,?)";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bx_stu);
			ps.setString(2, place);
			ps.setString(3, thing);
			ps.setString(4, description);
			ps.setString(5, date1);
			ps.setString(6, phone);
			ps.setString(7, pic_url);
			ps.executeUpdate();
			
			sql = "SELECT max(id) id FROM baoxiudan";
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				if((returnId=rs.getInt("id"))!=0) {
					System.out.println(returnId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnId;
	}

}
