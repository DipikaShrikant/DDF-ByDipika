package zJDBCPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class C_CreateEmployee {

	public static void main(String[] args) throws SQLException {

		Connection con = JDBCConnection.getconnection();
		String sql = "call AddEmployeeData()";

		CallableStatement cs = con.prepareCall(sql);
		

		cs.execute();

		cs.close();

		con.close();

	}

}
