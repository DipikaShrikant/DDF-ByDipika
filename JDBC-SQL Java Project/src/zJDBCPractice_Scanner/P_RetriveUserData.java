package zJDBCPractice_Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class P_RetriveUserData {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid");
		int userid = sc.nextInt();
		

		String sql = "select*from LoginData where userid=?";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		ps.close();
		con.close();
	}

}
