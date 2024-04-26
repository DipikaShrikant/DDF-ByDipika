package UsingStatmentInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCConfigue.JDBCConnection;

public class Retrive {

	public static void main(String[] args) throws SQLException {

		Connection con = JDBCConnection.getconnection();
//to get all the data in table
		String sql = "Select* from Student";

		Statement stmt = con.createStatement();

		ResultSet result = stmt.executeQuery(sql);

		while (result.next()) {
			System.out.println("============================================");
			System.out.println("roll no=" + result.getInt(1));// pass the row index
			System.out.println("name=" + result.getString(2));
			System.out.println("marks=" + result.getFloat(3));

		}

		// to get particular data from table

		String sql2 = "select * from student where rolno=33";
		
		ResultSet rs = stmt.executeQuery(sql2);
		while (rs.next()) {
			System.out.println("============================================");
			System.out.println("roll no=" + rs.getInt(1));// pass the row index
			System.out.println("name=" + rs.getString(2));
			System.out.println("marks=" + rs.getFloat(3));

		}
		stmt.close();
		con.close();
	}

}
