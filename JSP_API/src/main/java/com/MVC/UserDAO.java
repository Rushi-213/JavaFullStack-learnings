package com.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static Connection conn() {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Atharva$311");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		conn();
	}
	
	public static int SaveUser(AddInfo a) {
		conn();
		int r = 0;
		try {
			ps = con.prepareStatement("insert into user (name,email,city,age) values (?,?,?,?)");			
			ps.setString(1, a.getMyname());
			ps.setString(2, a.getMyemail());
			ps.setString(3, a.getMycity());
			ps.setInt(4, a.getMyage());
			
			r = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	
	public static AddInfo getByUserId(int id) {
		conn();
		
		AddInfo a = new AddInfo();
		try {
			ps = con.prepareStatement("Select * from user where id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int uid = rs.getInt("id");
				a.setId(uid);
				a.setMyname(rs.getString("name"));
				a.setMyemail(rs.getString("email"));
				a.setMycity(rs.getString("city"));
				a.setMyage(rs.getInt("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
}
