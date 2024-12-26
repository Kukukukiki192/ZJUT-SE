import java.io.*;
//import java.sql.PseudoColumnUsage;
//import java.util.HashMap;
//import java.util.Map;
//import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.html.parser.Entity;

@WebServlet("/register.do")
//@WebServlet(name = "RegisterServlet", urlPatterns = { "/register.do" })

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String passworddo=Sha256.getSHA256(password);//将密码以SHA256加密
		String name= request.getParameter("name");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String phoneNumber = request.getParameter("phoneNumber");
		String Path = "D:/web0322/WebContent/userInfo.txt";	//这里原来写成"userInfo.txt"找不到指定文件
		BufferedReader br=new BufferedReader(new FileReader(Path));
		String s;
		StringBuffer s1 = new StringBuffer();
		while((s=br.readLine())!=null) {
			s1.append(s);
			}
		String str = new String(s1);	
		String[] strArr = str.split("\\|");
		int flag=0;
		PrintWriter out =response.getWriter();
		for(int i=0;i<strArr.length;i=i+6) {
			if(userName.equals(strArr[i])) flag=1;
		}
		if (flag==1) response.sendRedirect("regiFail.html");
		else{
		BufferedWriter bw=new BufferedWriter(new FileWriter(Path,true));
		bw.write(userName+"|"+passworddo+"|"+name+"|"+sex+"|"+email+"|"+phoneNumber+"|"+"\n");		
		bw.close();
		response.sendRedirect("regiSuc.html");
     	}
		doGet(request, response);
	}

}
