package zJDBCPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class P_createWithEmployee {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		// String sql1 = "create table Employee(eid int,name varchar(25),age int,salary
		// double,department varchar(25))";

		System.out.println("enter the Employee id");
		int eid = sc.nextInt();

		System.out.println("enter the Employee name");
		String name = sc.next();

		System.out.println("enter the Employee age");
		int age = sc.nextInt();

		System.out.println("enter the Employee salary");
		double salary = sc.nextDouble();

		System.out.println("enter the Employee Department");
		String dept = sc.next();

		String sql2 = "insert into Employee values(?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql2);
		ps.setInt(1, eid);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setDouble(4, salary);
		ps.setString(5, dept);

		ps.execute();

		ps.close();

		con.close();
		System.out.println("Progarm Completed");
	}

}
