import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>Welcome to Servlet</h1>");
		
		String name = req.getParameter("MyName");
		String email = req.getParameter("MyEmail");
		String password = req.getParameter("MyPassword");
		String city = req.getParameter("MyCity");
		
		out.println("Name is : "+name+"<br>");
		out.println("Email is : "+email+"<br>");
		out.println("Password is : "+password+"<br>");
		out.println("City is : "+city+"<br>");
	}
}
