package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/download"})
public class FileDownloadServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, 
                HttpServletResponse response)
            		throws ServletException,IOException {
        HttpSession session = request.getSession();
        // 若用户没有登录则转到登录页面
        if (session == null || session.getAttribute("loggedIn") == null) {
            RequestDispatcher dispatcher = 
                   request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;   // 该语句是必须的
        }
        //String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/data");
        //File file = new File(dataDirectory, "Java.pdf");
        File file = new File("E:\\dance.mp4");
        if (file.exists()) {
            // 设置响应的内容类型为PDF文件
           response.setContentType("video/mp4");
            // 设置Content-Disposition响应头，指定文件名
            response.addHeader("Content-Disposition", "attachment;filename=dance.mp4");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);  // 创建文件输入流
                bis = new BufferedInputStream(fis);
                // 返回输出流对象
               OutputStream os = response.getOutputStream();
                // 读取1K的字节
               int i = bis.read(buffer);
               while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
               }
            } catch (IOException ex) {
                System.out.println (ex.toString());
            } finally {
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            }
        }else{
        	response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
    		out.println("文件不存在！");
        }
    }
}

