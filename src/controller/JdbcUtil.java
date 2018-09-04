package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	private static String connectionDriverClass="com.mysql.jdbc.Driver";
	private static String connectionUrl = "jdbc:mysql://localhost/lojainfo";
	private static String connectionUsername="root";
	private static String connectionPassword="";
	private static Connection conn;

	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(JdbcUtil.conn != null) {
			return JdbcUtil.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
					JdbcUtil.connectionUrl,
					JdbcUtil.connectionUsername,
					JdbcUtil.connectionPassword);
		}
		
	}
}
