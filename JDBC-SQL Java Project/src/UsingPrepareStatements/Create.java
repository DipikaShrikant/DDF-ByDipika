package UsingPrepareStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class Create {

	public static void main(String[] args) throws SQLException   {
		Scanner sc= new Scanner(System.in);
		
		Connection con = JDBCConnection.getconnection();
		
		String sql="insert into student values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		System.out.println("enter the rollno");
		int rollno = sc.nextInt();
		
		System.out.println("enter the name");
		String name = sc.next();
		System.out.println("enter the marks");
		float marks = sc.nextFloat();
		
		ps.setInt(1, rollno);
		ps.setString(2, name);
		ps.setFloat(3, marks);
		
		ps.execute();
		
		ps.close();
		con.close();


	}

}
