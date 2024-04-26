package UsingPrepareStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class Retrieve {

	public static void main(String[] args) throws SQLException {
		Connection con = JDBCConnection.getconnection();
		String sql = "select * from Student";

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("========================");
			System.out.println("roll no ="+rs.getInt(1));
			System.out.println("name="+rs.getString(2));
			System.out.println("marks"+rs.getFloat(3));

		}
		
		System.out.println("program done....!");
	}

}
