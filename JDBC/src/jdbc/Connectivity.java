package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {

	public static void main(String[] args)  {
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaFullStack","root", "Rushi@213");
		
		if(con!=null) {
			System.out.println("Connection Successfull.!!!");
		}
		else {
			System.out.println("Connection Failed...");
		}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
