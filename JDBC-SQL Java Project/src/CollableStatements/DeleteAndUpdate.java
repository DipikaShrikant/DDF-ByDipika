package CollableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import JDBCConfigue.JDBCConnection;

public class DeleteAndUpdate {

	public static void main(String[] args) throws SQLException {
		
		Connection con = JDBCConnection.getconnection();
		
		String sql="call DeleteAndUpdate(?,?,?)";
		
		CallableStatement cs = con.prepareCall(sql);
		
		cs.setInt(1, 106);
		cs.setInt(2, 108);
		cs.setString(3, "Asha");

		cs.executeUpdate();
		cs.close();
		con.close();

	}

}
