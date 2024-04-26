package zJDBCPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C_retrieveFromEmployee {

	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCConnection.getconnection();
		
		String sql="call GetEmployeeData()";
		
		CallableStatement cs = con.prepareCall(sql);
		
		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
			System.out.println("==============================");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getDouble(4));
			System.out.println(rs.getString(5));
		}
		
		cs.close();
		
		con.close();

	}

}
