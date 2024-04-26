package zJDBCPractice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class S_CreateEmployee {

	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCConnection.getconnection();
		
		String sql="insert into employee values(101,'Diksha',34,56.90,'Sql')";
		
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		
		stmt.close();
		con.close();

	}

}


