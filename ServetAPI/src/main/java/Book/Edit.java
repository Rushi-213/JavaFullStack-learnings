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


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String bookname = request.getParameter("mybookname");
		String bookedition = request.getParameter("mybookedition");
		String bookprice = request.getParameter("mybookprice");
		String id = request.getParameter("id");
		int uid = Integer.parseInt(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Atharva$311");
			
			PreparedStatement ps = con.prepareStatement("select * from book where id=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				out.print("<html>"
						+ "<head>"
						+ "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB' crossorigin='anonymous'>"
						+ "</head>"
						+ "<body>"
						+ "<form action='Updatebook' method='get'>"
						+ "<input type='text' name='id' value="+rs.getInt("id")+"><br>"
						+ "<input type='text' name='bookname' value="+rs.getString("bookname")+"><br>"
						+ "<input type='text' name='bookedition' value="+rs.getString("bookedition")+"><br>"
						+ "<input type='text' name='bookprice' value="+rs.getString("bookprice")+"><br><br>"
						+ "<input type='submit' value='Update'>"
						+ "<input type='reset' value='Clear'>"
						+ "</form>"
						+ "</body>"
						+ "</html>");
			}
			
			
		} catch (Exception e) {

		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
