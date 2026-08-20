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
import java.sql.ResultSet;

@WebServlet("/BookList")
public class BookList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Atharva$311");
			
			PreparedStatement ps = con.prepareStatement("select * from book");
			
			ResultSet rs = ps.executeQuery();
			out.println("<html>"
					+ "<head>"
					+ "<title>Book Information"
					+ "</title>"
					+ "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB' crossorigin='anonymous'>"
					+ "</head>"
					+ "<body>"
					+ "<table class='table table-dark table-striped' style='width:100%'>"
					+ "<tr>"
					+ "<th>Book ID</th>"
					+ "<th>Book Name</th>"
					+ "<th>Book Edition</th>"
					+ "<th>Book Price</th>"
					+ "<th>Edit</th>"
					+ "<th>Delete</th>"
					+ "</tr>");
			while(rs.next()) {
				int id = rs.getInt("id");
				out.println("<tr>"
						+ "<td>"+rs.getInt("id")+"</td>"
						+ "<td>"+rs.getString("bookname")+"</td>"
						+ "<td>"+rs.getString("bookedition")+"</td>"
						+ "<td>"+rs.getString("bookprice")+"</td>"
						+ "<td><a href='Edit?id="+id+"'>Edit</a>"
						+ "<td><a href='Deletebook?id="+id+"'>Delete</a>"
						+ "</tr>");
			}
			out.print("</table>"
					+ "</body>"
					+ "</html>");
		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
