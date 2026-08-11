import java.io.IOException;
import java.io.PrintWriter;

import com.sun.net.httpserver.Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		String u= req.getParameter("UserName");
		String p=req.getParameter("Password");
		Boolean result=ValidationLogin.validate(u, p);
		
		if(result) {
			RequestDispatcher rd= req.getRequestDispatcher("Index.html");
		}
	}
}