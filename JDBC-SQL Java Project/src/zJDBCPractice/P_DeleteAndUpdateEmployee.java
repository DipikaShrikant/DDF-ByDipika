package zJDBCPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class P_DeleteAndUpdateEmployee {

	public static void main(String[] args) throws SQLException {
		Connection con = JDBCConnection.getconnection();

		String sql = "delete from Employee where eid=?";

		String sql2 = "update employee set name=? where eid=?";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, 101);
		ps.executeUpdate();
		
		
		PreparedStatement ps1 = con.prepareStatement(sql2);
		ps1.setString(1, "Sagar");
		ps1.setInt(2, 102);

		ps1.executeUpdate();
		
		ps.close();
		con.close();

	}

}
