package org.fasttrackit.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {
	
	public Connection getConnectionCategorii()  {
		Properties connectionsProps = new Properties();
		connectionsProps.put("user", "root");
		connectionsProps.put("password", "*2Go9x}cZ_M}");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//return DriverManager.getConnection("jdbc:mysql://185.146.87.240/europart_test1?serverTimezone=UTC",
				//	connectionsProps);
			return DriverManager.getConnection("jdbc:mysql://185.146.87.187/europart_test1?serverTimezone=UTC",
					connectionsProps);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
