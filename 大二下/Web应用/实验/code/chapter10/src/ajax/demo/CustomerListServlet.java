package ajax.demo;
import java.io.*;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name ="customerList", urlPatterns={"/customerList.do" })
public class CustomerListServlet extends HttpServlet {
    protected void addCustomer(HttpServletRequest request,
                               HttpServletResponse response)
                             throws ServletException, IOException {
        // 可将对象存储到数据库中
        String uniqueID = storeCustomer();
        // 创建响应XML
        StringBuffer xml = new StringBuffer("<result><uniqueID>");
        xml.append(uniqueID);
        xml.append("</uniqueID>");
        xml.append("<status>1</status>");
        xml.append("</result>");
        // 向浏览器发送响应
        sendResponse(response, xml.toString());
    }
    protected void deleteCustomer(HttpServletRequest request,
                                     HttpServletResponse response)
                                  throws ServletException, IOException {
        String id = request.getParameter("id");
        // 可将客户从数据库中删除
        // 创建响应XML
        StringBuffer xml = new StringBuffer("<result>");
        xml.append("<status>1</status>");
        xml.append("</result>");
        // 向浏览器发送响应
        sendResponse(response, xml.toString());
    }
 
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response)
                            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("add")) {
            addCustomer(request, response);
        }
        else if(action.equals("delete")) {
            deleteCustomer(request, response);
        }
    }
 
    private String storeCustomer() {
        // 这里可将客户对象保存到数据库中
        String uniqueID = "";
        Random randomizer = new Random(System.currentTimeMillis());
        for(int i = 0; i < 8; i++) {
            uniqueID += randomizer.nextInt(9);
        }
        return uniqueID;
    }
    private void sendResponse(HttpServletResponse response, 
              String responseText)
                           throws IOException {
        response.setContentType("text/xml");
        response.getWriter().println(responseText);
    }
}

