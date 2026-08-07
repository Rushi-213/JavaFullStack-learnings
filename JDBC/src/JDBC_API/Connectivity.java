package JDBC_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
	
		public static Connection con() {
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaFullStack","root", "Rushi@213");
		
		if(con!=null) {
			System.out.println("Connection Successfull.!!!");
		}
		
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		}
}
