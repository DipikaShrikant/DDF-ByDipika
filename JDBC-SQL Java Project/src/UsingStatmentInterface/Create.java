package UsingStatmentInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/dipikasworkspace","root", "root");

		String sql1 = "create table Student(rolno int,name varchar(25), marks float)";

		String sql2 = "insert into Student values(22,'Dipika',95.95)";
		String sql3 = "insert into Student values(11,'Anjali',85.95)";
		String sql4 = "insert into Student values(33,'Kajal',95.25)";

		Statement stment = con.createStatement();
		stment.execute(sql1);
		stment.execute(sql2);
		stment.execute(sql3);
		stment.execute(sql4);


		stment.close();
		con.close();

		System.out.println("program executed successfully");

	}

}
