package zJDBCPractice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class S_UpdateAndDeleteEmployee {

	public static void main(String[] args) throws SQLException {
Connection con = JDBCConnection.getconnection();
		
		String sql="delete from employee where eid=101";
		
		String sql2="update employee set department='javascript' where eid=109";
		
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		stmt.execute(sql2);
		
		stmt.close();
		con.close();

	}

}
