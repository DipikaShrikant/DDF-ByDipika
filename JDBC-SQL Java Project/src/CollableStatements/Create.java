package CollableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class Create {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		Connection con = JDBCConnection.getconnection();
		String sql = "call AddData(?,?,?)";
		CallableStatement cs = con.prepareCall(sql);

		System.out.println("enter the rollno");
		int rollno = sc.nextInt();

		System.out.println("enter the name");
		String name = sc.next();
		System.out.println("enter the marks");
		float marks = sc.nextFloat();
		
		
		cs.setInt(1, rollno);
		cs.setString(2, name);
		cs.setFloat(3, marks);
		
		cs.execute();
		
		cs.close();
		con.close();

	}

}
