package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver"; // mysql驱动
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/qiruan?useUnicode=true&characterEncoding=UTF-8"; // mysql
	private static final String USER = "root"; // 数据库用户名
	private static final String PASSWORD = "xiaofeng"; // 数据库密码
	private static Connection conn = null;

	// 静态代码块,优先执行
	static {
		// 1.加载去驱动
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DBUtil工具类-->加载驱动失败:" + e.getMessage());
		}
	}

	// 2.获取连接
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("DBUtil工具类-->获取连接失败,原因为:" + e.getMessage());
		}
		return null;
	}
}
