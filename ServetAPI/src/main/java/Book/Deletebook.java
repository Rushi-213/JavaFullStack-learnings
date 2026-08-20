package Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/Deletebook")
public class Deletebook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		int uid = Integer.parseInt(id);
		String bookname = request.getParameter("bookname");
		String bookedition = request.getParameter("bookedition");
		String bookprice = request.getParameter("bookprice");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Atharva$311");
			
			String resetCounterSQL = "ALTER TABLE book AUTO_INCREMENT = 1";
			String deleteSQL = "delete from book where id=?";
			
			PreparedStatement ps = con.prepareStatement(deleteSQL);
			ps.setInt(1, uid);
			int r = ps.executeUpdate();
			if(r>0) {
				out.print("Data Deleted<br>");
				out.print("<a href='BookList'>View Records</a>");
			}
			else {
				out.print("Data Not Deleted");
				out.print("<a href='BookList'>Go Back</a>");
			}
			
//			String shiftSQL = "UPDATE users SET id = id - 1 WHERE id > ?";
//			PreparedStatement shiftStmt = con.prepareStatement(shiftSQL);
//			shiftStmt.setInt(1, uid);
//          shiftStmt.executeUpdate();
//            
			PreparedStatement resetStmt = con.prepareStatement(resetCounterSQL);
			resetStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
