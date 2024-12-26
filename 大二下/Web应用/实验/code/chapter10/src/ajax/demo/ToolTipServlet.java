package ajax.demo;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name ="tooltipServlet", urlPatterns={"/toolTip.do" })
public class ToolTipServlet extends HttpServlet {
    private Map<String,String> dogs = new HashMap<String,String> ();
    public void init(ServletConfig config) throws ServletException {  
        dogs.put("dog1", "It is a dog!");
        dogs.put("dog2", "It is a lovely dog!");
        dogs.put("dog3", "It is a very lovely dog!");
    }
 
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                          throws ServletException, IOException {
        String key = request.getParameter("key");
        String data = dogs.get(key);
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        out.println("<response>");
        out.println("<description>" + data + "</description>");
        out.println("</response>");
        out.close();
    }
}
