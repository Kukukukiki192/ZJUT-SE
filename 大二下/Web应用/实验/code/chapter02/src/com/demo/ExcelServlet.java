package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="ExcelServlet",urlPatterns={"/excel.do"})
public class ExcelServlet extends HttpServlet{
   public void doGet(HttpServletRequest request, 
HttpServletResponse response)
                      throws ServletException, IOException{
// 璁剧疆鍝嶅簲鐨勫唴瀹圭被鍨�
response.setContentType("application/vnd.ms-excel;charset=utf-8");
    PrintWriter out = response.getWriter();
   
    out.println("瀛﹀彿\t濮撳悕\t鎬у埆\t骞撮緞\t鎵�鍦ㄧ郴");
    out.println("95001\t鏉庡媷\t鐢穃t20\t淇℃伅");
    out.println("95002\t鍒樻櫒\t濂砛t19\t鏁板");
  }
}

