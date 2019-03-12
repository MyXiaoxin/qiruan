package test;

import entity.Baoxiudan;
import model.Pager;
import service.JdbcSql;

public class Test04 {
	public static void main(String[] args) {
	JdbcSql jdbc = new JdbcSql();
	Pager pager = jdbc.showMess(2);
	for(Baoxiudan bxd : pager.getData()) {
		System.out.println(bxd.getId());
	}
	
	}

}
