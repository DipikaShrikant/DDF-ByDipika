package zJDBCPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class C_UpdateAndDelete {

	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCConnection.getconnection();
		
		String sql="Call UpdateEmployee()";
		
		CallableStatement cs = con.prepareCall(sql);
		
		cs.executeUpdate();
		
		cs.close();
		
		con.close();

	}

}
