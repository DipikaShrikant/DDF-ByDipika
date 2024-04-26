package UsingStatmentInterface;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCConfigue.JDBCConnection;

public class UpdateAndDelete {

	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCConnection.getconnection();
		
		String  sql="Delete from Student where rolno=33";
		
		String sql2="update student set name='Divyansh',rolno=101 where rolno=11";
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql2);

		stmt.close();
		con.close();

	}

}
;