package zJDBCPractice_Scanner;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class C_Create {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid");
		int userid = sc.nextInt();
		System.out.println("enter username");
		String username = sc.next();
		System.out.println("enter Password");
		String password = sc.next();
		String sql = "call LoginCreates(?,?,?)";

		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, userid);
		cs.setString(2, username);
		cs.setString(3, password);

		cs.execute();
		cs.close();
		con.close();
	}

}
