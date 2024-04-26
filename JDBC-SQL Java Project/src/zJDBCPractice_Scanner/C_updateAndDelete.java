package zJDBCPractice_Scanner;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class C_updateAndDelete {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		System.out.println("enter userid");
		int userid = sc.nextInt();
		System.out.println("enter useusername");
		String username = sc.next();

		String sql = "call UpdateAndDeleteLogin(?,?,?)";

		CallableStatement cs = con.prepareCall(sql);
		
		cs.setInt(1, userid);
		
		cs.setString(2, username);
		
		cs.setInt(3,userid);

		cs.executeUpdate();

		cs.close();
		con.close();
	}

}
