package UsingPrepareStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JDBCConfigue.JDBCConnection;

public class UpdateAndDelete {

	public static void main(String[] args) throws SQLException {
		Connection con = JDBCConnection.getconnection();
		String sql = "delete from Student where rolno=106";
		
		String sql2="update Student set name='yuvaaan', rolno=107 where rolno=102 ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute(sql2);
		
		ps.close();

		con.close();
		
	}

}
