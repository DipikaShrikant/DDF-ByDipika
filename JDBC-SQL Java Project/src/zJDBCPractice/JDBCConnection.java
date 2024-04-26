package zJDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private static Connection con = null;

	public static Connection getconnection() {
		if (con == null) {
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dipikasworkspace", "root", "root");

				return con;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return con;

	}
}
