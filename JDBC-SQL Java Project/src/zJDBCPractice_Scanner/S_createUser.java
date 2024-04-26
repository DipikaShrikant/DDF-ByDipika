package zJDBCPractice_Scanner;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class S_createUser {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid");
		int userid = sc.nextInt();
		System.out.println("enter username");
		String username = sc.next();
		System.out.println("enter Password");
		String password = sc.next();

		//String sql = "create table LoginData(userid int, username varchar(25),password varchar(25))";
		String sql2 = "insert into LoginData values(" + userid + ",'" + username + "','" + password + "')";

		Statement stmt = con.createStatement();
		//stmt.execute(sql);
		
		stmt.execute(sql2);
		stmt.close();
		con.close();
	}

}
