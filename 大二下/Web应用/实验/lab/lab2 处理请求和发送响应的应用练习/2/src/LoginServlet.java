import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check.do")
//@WebServlet(name = "LoginServlet", urlPatterns = { "/check.do" })

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String passworddo=Sha256.getSHA256(password);
		BufferedReader bw=new BufferedReader(new FileReader("D:/web0322/WebContent/userInfo.txt"));
		String s;
		StringBuffer s1 = new StringBuffer();
		while((s=bw.readLine())!=null) {
			s1.append(s);
			}
		String str = new String(s1);	
		String[] strArr = str.split("\\|");
		int flag=0;
		PrintWriter out =response.getWriter();
		for(int i=0;i<strArr.length;i=i+6) {
			out.println((strArr[i])+(strArr[i+1]));
			if(userName.equals(strArr[i])&&passworddo.equals(strArr[i+1])) flag=1;
		}
		if (flag==1) response.sendRedirect("welcome.html");
		else response.sendRedirect("fail.html");		
		bw.close();
		doGet(request, response);
	}
}
