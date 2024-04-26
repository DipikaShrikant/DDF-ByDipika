package UsingStatmentInterface;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcConnection;

import JDBCConfigue.JDBCConnection;

public class CreateUsingScanner {

	public static void main(String[] args) throws SQLException {
		Scanner sc= new Scanner(System.in);
		
		Connection con=JDBCConnection.getconnection();

		System.out.println("enter the rollno");
		int rollno = sc.nextInt();
		System.out.println("enter the name");
		String name = sc.next();
		System.out.println("enter the marks");
		float marks = sc.nextFloat();
		
		String sql="insert into Student values"
				+ "("+rollno+",'"+name+"',"+marks+")";
		
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		
		stmt.close();
		con.close();
		
		
		

	}

}
