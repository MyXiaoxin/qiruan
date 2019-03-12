package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Repairer;
import model.RepairerPager;
import tools.DBUtil;


public class RepairerPagesDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private List<Repairer> list;
	private ResultSet rs = null;
	private int total;
	public RepairerPager repairerPages(int num) {
		list = new ArrayList<Repairer>();
		String sql ="select * from weixiu limit " + ((num-1) * 2) + "," +2;//每页显示2条记录
		conn = DBUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String str = "";
			int number;
			while(rs.next()) {
				Repairer r =new   Repairer();
				if((number=rs.getInt("id"))!=0) {
					r.setId(number);
				}
				if((str=rs.getString("name"))!=null) {
					r.setName(str);
				}
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql1 = "select count(id) total from weixiu"; 
		try {
			rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		total = total / 2;
		if(total%2!=0) {
			total++;
		}
		return new RepairerPager(num,total,list);
	}

}
