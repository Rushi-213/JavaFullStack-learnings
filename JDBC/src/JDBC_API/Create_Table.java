package JDBC_API;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table {

	public static void main(String[] args) throws SQLException {
		Connection con= Connectivity.con();
		String query="Create table user1(id int auto_increment unique,name varchar(30),city varchar(30),salary int)";
		Statement stmt=con.createStatement();
		boolean X=stmt.execute(query);
		if(!X) {
			System.out.println("Created Successfully");
		}
		else {
			System.out.println("Failed....");
		}
	}

}
