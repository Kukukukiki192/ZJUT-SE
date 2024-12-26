package ajax.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "validationServlet", urlPatterns = { "/validation.do" })
public class ValidationServlet extends HttpServlet{
  public void doGet(HttpServletRequest request,
           HttpServletResponse response)
                   throws ServletException,IOException{
    response.setContentType("text/xml;charset=UTF-8");
    response.setHeader("Cache-Control","no-cache");
    
    String username = request.getParameter("username");
    String message = "用户名可以使用！";
PrintWriter out = response.getWriter();
//这里的验证非常简单，实际应用可与数据库中用户名比较
    if(username.equals("hacker")){
      message = "用户名已被占用！";
    }
    out.println("<response>");
    out.println("<message>"+message+"</message>");
    out.println("</response>");
  }  
}


