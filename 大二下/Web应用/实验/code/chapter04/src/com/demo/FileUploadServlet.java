package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name="FileUploadServlet",urlPatterns={"/fileUpload.do"})
@MultipartConfig(location="D:\\",fileSizeThreshold=1024)
public class FileUploadServlet extends HttpServlet{
    // 返回上传来的文件名
    private String getFilename(Part part){
        String fname = null;
        // 返回上传的文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        System.out.println(header);
        // 返回不带路径的文件名
        fname = header.substring(header.lastIndexOf("=")+2, 
                                 header.length()-1);
        return fname;
    }
    
    public void doPost(HttpServletRequest request, 
                   HttpServletResponse response) 
                throws ServletException,IOException{
        // 返回Web应用程序文档根目录
        String path = this.getServletContext().getRealPath("/");
        String mnumber = request.getParameter("mnumber");
        Part p = request.getPart("fileName");
        String message="";
        if(p.getSize() >1024*1024){    // 上传的文件不能超过1MB大小
          p.delete();
          message = "文件太大，不能上传！";
        }else{
          // 文件存储在文档根目录下member子目录中会员号子目录中
          path = path + "\\member\\" +mnumber;
          File f = new File(path);
          if( !f.exists()){  // 若目录不存在，则创建目录
            f.mkdirs();
         }
         String fname = getFilename(p);   // 得到文件名
         System.out.println(fname);
         p.write(path + "\\"+ fname);     // 将上传的文件写入磁盘
         message = "文件上传成功！";
    }
    request.setAttribute("message", message);
    RequestDispatcher rd = request.getRequestDispatcher("/fileUpload.jsp");
    rd.forward(request, response);
   }
}

