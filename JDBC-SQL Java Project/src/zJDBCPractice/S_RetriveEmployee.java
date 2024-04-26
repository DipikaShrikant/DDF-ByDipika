package zJDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class S_RetriveEmployee {

	public static void main(String[] args) throws SQLException {
		
Connection con = JDBCConnection.getconnection();
		
		String sql="select * from employee";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("=============================");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getDouble(4));
			System.out.println(rs.getString(5));

		}
		
		stmt.close();
		con.close();


	}

}
