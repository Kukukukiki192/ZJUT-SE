
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException{

		String username = req.getParameter("username");

		String password = req.getParameter("password");

		if("admin".equals(username) && "123456".equals(password)) {

			ServletContext context = getServletContext();

			RequestDispatcher dispatcher = context.getNamedDispatcher("dispatcher");

			dispatcher.forward(req, res);

		}else {

			throw new RuntimeException("Login failed.");

		}
	}

}