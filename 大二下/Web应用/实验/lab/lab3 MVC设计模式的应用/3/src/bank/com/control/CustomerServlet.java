package bank.com.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bank.com.model.LoginDB;

@WebServlet("CustomerServlet.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email=request.getParameter("Email"); 
		String Password=request.getParameter("Password");
		String CustName=request.getParameter("CustName");
		String Phone=request.getParameter("Phone");
		
		LoginDB loginDB = (LoginDB) getServletContext().getAttribute("loginDB");
		if (loginDB == null) {
		loginDB = new LoginDB();
		}
		loginDB.addUser(Email,Password,CustName,Phone);
		getServletContext().setAttribute("loginDB", loginDB);
		
		String Path = "D:/web4_12/WebContent/customerinfo.txt";	
		BufferedWriter bw=new BufferedWriter(new FileWriter(Path,true));
		bw.write(Email+"|"+Password+"|"+CustName+"|"+Phone+"\n");		
		bw.close();
		
		RequestDispatcher rd=request.getRequestDispatcher("/bank/displayCustomer.jsp");
		rd.forward(request, response);
		}
}