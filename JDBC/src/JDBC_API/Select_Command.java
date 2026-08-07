package JDBC_API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select_Command {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=Connectivity.con();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id:");
		int id=sc.nextInt();
		
		PreparedStatement ps= con.prepareStatement("delete from java where id = ?");
		
		ps.setInt(1, id);
		
		int num=ps.executeUpdate();
		if(num>0) {
			System.out.println("Deleted Successfull");
		}
		else {
			System.out.println("Error");
		}
		
	}

}
