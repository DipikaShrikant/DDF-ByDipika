package zJDBCPractice_Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class S_updateAndDeleteUser {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter username to set the data");
		String name = sc.next();
		System.out.println("enter userid to Set the data");
		int userid = sc.nextInt();
		

		String sql = "update Logindata set username='" + name + "' where userid=" + userid + "";
		Statement stmt = con.createStatement();

		stmt.executeUpdate(sql);

		stmt.close();
		con.close();

	}

}
