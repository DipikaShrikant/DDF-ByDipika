package CollableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcConnection;

import JDBCConfigue.JDBCConnection;

public class Retrieve {

	public static void main(String[] args) throws SQLException {
		
		//using stored procedure
		Connection con = JDBCConnection.getconnection();
		String sql="{call getAllData()}";
		
		CallableStatement cs = con.prepareCall(sql);
		
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
