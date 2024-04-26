package zJDBCPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P_RetriveFromEmployee {

	public static void main(String[] args) throws SQLException {
		Connection con = JDBCConnection.getconnection();

		String sql = "Select * from Employee";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("==============================");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getDouble(4));
			System.out.println(rs.getString(5));

		}
		ps.close();
		con.close();
	}

}
