package UsingPrepareStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCConfigue.JDBCConnection;

public class CRUDOperations {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = JDBCConnection.getconnection();
		PreparedStatement ps = null;
		System.out.println(
				"select /n" 
		+ "1. create the data" 
		+ "2.retrive the data" 
		+ "3.delete the data" 
		+ "4.update the data");

		int ch = sc.nextInt();
		if (ch == 1) {
			String sql1 = "insert into student values(?,?,?)";
			ps = con.prepareStatement(sql1);
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

		} else if (ch == 2) {
			String sql2 = "select * from student";
			ps = con.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("=============================");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getFloat(3));

			}
		} else if (ch == 3) {
			String sql3 = "Delete from student where rolno=101";
			ps = con.prepareStatement(sql3);
			ps.executeUpdate();
		}

		else if (ch == 4) {
			String sql4 = "update student set name='Agastya' where rolno=22";
			ps = con.prepareStatement(sql4);
			ps.executeUpdate();
		}

		ps.close();
		con.close();
	}

}
