package SessionTrackin;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SessionTrackin/URLServlet1")
public class URLServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Welcome to Servlet</h1>");
		
		String name = request.getParameter("MyName");
		String city = request.getParameter("MyCity");
		
		out.println("Name is : "+name+"<br>");
		out.println("City is : "+city+"<br>");
		
		//out.println("<a href= 'URLServlet2'> Click ME </a>");
		
		out.println(" <form action='URLServlet2' method='get'>");
		out.println("<input type='hidden' name='Name' value="+name+">");
		out.println("<input type='hidden' name='City' value="+city+">");
		out.println("<input type='submit'>");
		out.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
