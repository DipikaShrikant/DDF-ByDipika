package zJDBCPractice_Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class P_UpdateAndDeleteUser {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid");
		int userid = sc.nextInt();
		System.out.println("Enter name to set the data");
		String username = sc.next();
		System.out.println("enter userid");
		int userid2 = sc.nextInt();
		String sql = "delete from LoginData where userid=?";

		String sql2 = "upadate LoginData set name=? where userid=? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userid);
		ps.executeUpdate();
		
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setString(1, username);
		ps2.setInt(2, userid2);

		ps2.executeUpdate();

		ps.close();
		ps2.close();
		con.close();

	}

}
