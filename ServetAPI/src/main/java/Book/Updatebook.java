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

@WebServlet("/Updatebook")
public class Updatebook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String bookname = request.getParameter("bookname");
		String bookedition = request.getParameter("bookedition");
		String bookprice = request.getParameter("bookprice");
		String id = request.getParameter("id");
		int uid = Integer.parseInt(id);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Atharva$311");
			
			PreparedStatement ps = con.prepareStatement("update book set bookname=?, bookedition=?, bookprice=? where id=?");
			ps.setString(1, bookname);
			ps.setString(2, bookedition);
			ps.setString(3, bookprice);
			ps.setInt(4, uid);
			int r = ps.executeUpdate();
			if(r>0) {
				out.print("Data Updated");
				out.print("<a herf='BookList'>View Records</a>");
			}
			else {
				out.print("Data Not Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
