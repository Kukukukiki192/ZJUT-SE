import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/TriangleServlet")
@WebServlet(name = "TriangleServlet", urlPatterns = { "/computeTriangleArea.do" })

public class TriangleServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
		double a=Double.parseDouble(request.getParameter("a"));
		double b=Double.parseDouble(request.getParameter("b"));
		double c=Double.parseDouble(request.getParameter("c"));
		if((a+b)>c&&(a+c)>b&&(b+c)>a) {
			double p=(a+b+c)/2;
			double s=Math.sqrt(p*(p-a)*(p-b)*(p-c));
			double f=(double)Math.round(s*100)/100;//round()方法可把一个数字舍入为最接近的整数
			out.println("3条边长可构成三角形,S="+f);
		}
		else { out.println("3条边长无法构成三角形"); }
		}catch(Exception e) {  
			out.println("输入的边长有误！");
		}  
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}
}
