package zJDBCPractice_Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class P_CreateUser {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid");
		int userid = sc.nextInt();
		System.out.println("enter username");
		String username = sc.next();
		System.out.println("enter Password");
		String password = sc.next();

		String sql = "insert into LoginData values(?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userid);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.execute();
		ps.close();
		con.close();
	}

}
