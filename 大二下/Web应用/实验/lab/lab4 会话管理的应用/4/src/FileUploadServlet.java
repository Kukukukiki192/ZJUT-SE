/*上传成功后将学号、姓名、作业标题和上传时间以及作业文件名（学号_当前时间戳的值命名文件，
 * 其中当前时间戳的值=new java.util.Date().getTime()/1000）
 * 存入homework.txt文件中*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.UserBean;
import java.util.Date;
import java.text.*;

@WebServlet("/FileUploadServlet")
@MultipartConfig(location="D:\\",fileSizeThreshold=1024)
public class FileUploadServlet extends HttpServlet{
    
    private String getFilename(Part part){ // 返回上传的文件名
        String fname = null;
        // 返回上传的文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        System.out.println(header);
        // 返回不带路径的文件名
        fname = header.substring(header.lastIndexOf("=")+2, header.length()-1);
        return fname;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // 返回Web应用程序文档根目录
    	request.setCharacterEncoding("UTF-8");
        String path = this.getServletContext().getRealPath("/");
        String workName=request.getParameter("workName");
        Part p=request.getPart("fileName");
        String message="";
        if(p.getSize() >1024*1024){    // 上传的文件不能超过1MB大小
          p.delete();
          message = "文件太大，不能上传！";
        }else{// 文件存储在文档根目录下files子目录中
          path = path + "/WebContent/WEB-INF/files/" + workName;
          File f = new File(path);
          if( !f.exists()){  // 若目录不存在，则创建目录
            f.mkdirs();
          }
//         String ff= getFilename(p);   // 得到文件名
//         System.out.println(ff);
//         p.write(path + "/"+ ff);     // 将上传的文件写入磁盘
         message = "文件上传成功！";
        }
        
        //学号、姓名、作业标题、上传时间、作业文件名存入homework.txt
        //判断session是否存在
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            RequestDispatcher dispatcher =  request.getRequestDispatcher("login.jsp");//未登录,则跳转至登录页面
            dispatcher.forward(request, response);
            return;  
        }
        UserBean c= (UserBean)session.getAttribute("user");
        String T=new SimpleDateFormat("yyyy-M-d H:mm:ss").format(new Date());
        long t=new Date().getTime()/1000;//long getTime()方法返回自1970年1月1日00:00:00 GMT过去了多少毫秒,返回一个long类型的时间戳
        String fname=c.getNum()+"_"+t+".doc";
        String Path = "D:/Web应用/4/WebContent/WEB-INF/homework.txt";
        BufferedWriter bw=new BufferedWriter(new FileWriter(Path,true));
		bw.write(c.getNum()+"\t"+c.getName()+"\t"+workName+"\t"+T+"\t"+fname+"\t"+"\n");		
		bw.close();
    request.setAttribute("message", message);
    RequestDispatcher rd = request.getRequestDispatcher("uploadHomework.jsp");
    rd.forward(request, response);
   }
}