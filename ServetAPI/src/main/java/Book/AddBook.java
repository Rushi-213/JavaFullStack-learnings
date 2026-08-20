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

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String bookname = request.getParameter("mybookname");
		String bookedition = request.getParameter("mybookedition");
		String bookprice = request.getParameter("mybookprice");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Rushi@213");
			
			PreparedStatement ps = con.prepareStatement("insert into book(bookname,bookedition,bookprice) values (?,?,?)");
			ps.setString(1, bookname);
			ps.setString(2, bookedition);
			ps.setString(3, bookprice);
			
			int r = ps.executeUpdate();
			
			if(r>0) {
				out.print("Data inserted.......");
			}
			else {
				out.print("Data not inserted.......");
			}
		} catch (Exception e) {

		}
		out.println("<form action='BookList'>");
		out.println("<button type='submit'>View Records</button>");
		out.print("</form>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
