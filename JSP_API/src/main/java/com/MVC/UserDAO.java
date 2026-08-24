package com.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	
	public static Connection conn;
	public static PreparedStatement ps;
	
	public static Connection con() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql;//localhost:3308/javafullstack","root","Rushi@213");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	public static AddInfo saveInfo(AddInfo a) {
		
	
		return null;
		
	}
	
	
}
