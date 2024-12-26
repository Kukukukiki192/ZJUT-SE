package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fileDownload.do")
public class FileDownloadServlet extends HttpServlet{
     public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
         // 设置文件的内容类型
response.setContentType("image/gif");
// 设置Content-Disposition响应头，指定文件名
response.setHeader("Content-Disposition",
"attachment;filename=coffee.gif");
// 获得输出流对象
OutputStream os = response.getOutputStream();
         ServletContext context = getServletContext();
         // 返回输入流对象
     InputStream is = 
context.getResourceAsStream("/images/coffee.gif");
byte[] bytearray = new byte[1024]; 
         int bytesread = 0;
         // 从输入流中读取1K字节，然后写到输出流中
         while((bytesread = is.read(bytearray)) != -1 ){
            // 将数据发送到客户端
os.write(bytearray, 0, bytesread);
         }
         os.flush();
         is.close();
     }
}

