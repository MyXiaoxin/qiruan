package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tools.DBUtil;

public class Test13 {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	public static void main(String[] args) {
		String sql = "update weixiu set name='李师傅' where id =201602";
		String sql1 = "insert into comment (weixiudan_id,neirong) values ('16','修的不错')";
		String sql2 = "insert into user(id,password,username,tx_url,user_sex,user_birth,user_dept)values(\"201603\",\"123456\",\"zhangsan\",\"touxiang\",\"man\",\"1996-8-10\",\"ma\")";
		String sql3="insert into weixiu(id,password,name,tx_url,user_sex,user_dept,phone)values(201602,\"123456\",\"老李\",\"\",\"男\",\"明德物业\",\"17854110000\");";
		String sql4 = "update user set username='李师傅' where id =201602";
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
