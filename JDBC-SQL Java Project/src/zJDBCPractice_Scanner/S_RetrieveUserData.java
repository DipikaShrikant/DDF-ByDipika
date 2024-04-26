package zJDBCPractice_Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class S_RetrieveUserData {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid to get the data");
		int userid = sc.nextInt();

		String sql = "select * from Logindata where userid=" + userid + "";
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		stmt.close();
		con.close();

	}

}
