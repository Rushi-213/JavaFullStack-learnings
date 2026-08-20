

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HttpSessionServlet")
public class HttpSessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Welcome to Servlet</h1>");
		
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		out.println("Name is : "+username+"<br>");
		out.println("City is : "+password+"<br>");
		
		HttpSession h=request.getSession();
		h.setAttribute("password1:", password);
		h.setAttribute("username is:", username);
		
		out.print("<a href='HttpSessionServlet2'> click me </a>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
