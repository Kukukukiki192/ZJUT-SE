package demo;

import java.io.IOException;
import java.net.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {						
		request.setCharacterEncoding("UTF-8");//非常重要！！！不然中文传参会乱码
		String search=request.getParameter("search");	
		HttpSession session = request.getSession(); 
		if (search != null) {
//			request.setAttribute("search", search);	//用这个跳转不了
			session.setAttribute("search",search); 
	       	response.sendRedirect("result.jsp");//第2、4题
	     	return;
	  	} else {
	    	response.sendRedirect("search.jsp");
		}
	}
}