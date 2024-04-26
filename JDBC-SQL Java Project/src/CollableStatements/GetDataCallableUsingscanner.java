package CollableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class GetDataCallableUsingscanner {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		Connection con = JDBCConnection.getconnection();
		System.out.println("enter roll no to getstudent data");

		int rollno = sc.nextInt();

		String sql = "call getdata(?)";

		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, rollno);
		
		ResultSet rs = cs.executeQuery();
		
		while(rs.next()) {
			System.out.println("=============================");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getFloat(3));		
		}
			cs.close();
		con.close();
	}

}
