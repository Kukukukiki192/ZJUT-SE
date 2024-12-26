package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.UserDao;
import com.model.Student;
import com.model.Teacher;

@WebServlet("/Import")
@MultipartConfig(location="D:/",fileSizeThreshold=1024)
public class Import extends HttpServlet {
	private String getFilename(Part part){ // 返回上传的文件名
        String fname = null;
        // 返回上传的文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        System.out.println(header);
        // 返回不带路径的文件名
        fname = header.substring(header.lastIndexOf("=")+2, header.length()-1);
        return fname;
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type"));
		String num = request.getParameter("num");
		request.setAttribute("num", num);
//		String path = this.getServletContext().getRealPath("/");
		String path;
		
		Part p=request.getPart("file");
		String result="";
		if(p==null)System.out.print("null");
	    if(p.getSize() >1024*1024){    // 上传的文件不能超过1MB大小
	    	p.delete();
	        result = "文件太大，不能上传！";
	    }else{// 文件存储在文档根目录下files子目录中
//	    	path = path + "/WebContent/file/" + getFilename(p);
	    	path = "D:/Web应用/健康码管理系统/WebContent/file/" + getFilename(p);
	        File f = new File(path);
	        if( !f.exists()) f.mkdirs(); // 若目录不存在，则创建目录
	        System.out.print(path);
	        p.write(path);     // 将上传的文件写入磁盘
	        
	        BufferedReader br=new BufferedReader(new FileReader(path));
			String s;
			StringBuffer s1 = new StringBuffer();
			while((s=br.readLine())!=null) {
				s1.append(s+"\t");
			}br.close();
			String str = new String(s1);	
			String[] strArr = str.split("\t");
			UserDao dao = new UserDao();
			if(type==1) {
				ArrayList<Student> sList = new ArrayList<Student>();
			    for(int i=0;i<strArr.length;i+=6) {	 
			    	//测试数据
			    	System.out.println(strArr[i]+" "+strArr[i+1]+" "+strArr[i+2]+" "+strArr[i+3]+" "+strArr[i+4]+" "+strArr[i+5]);   	
			    	Student student= new Student(strArr[i],strArr[i+1],strArr[i+2],"1111",strArr[i+3],strArr[i+4],strArr[i+5]);
			    	sList.add(student);
			    }
			    if(dao.addSlist(sList)) {
					result="批量导入学生用户成功！"; 
				}else {
					result="批量导入学生用户失败！"; 
				}	
			}else {
				ArrayList<Teacher> tList = new ArrayList<Teacher>();
			    for(int i=0;i<strArr.length;i+=5) {	  
			    	//测试数据
			    	System.out.println(strArr[i]+" "+strArr[i+1]+" "+strArr[i+2]+" "+strArr[i+3]+" "+strArr[i+4]);   	
			    	Teacher teacher= new Teacher(strArr[i],strArr[i+1],strArr[i+2],"1111",strArr[i+3],strArr[i+4]);
			    	tList.add(teacher);
			    }
			    if(dao.addTlist(tList)) {
					result="批量导入教师用户成功！"; 
				}else {
					result="批量导入教师用户失败！"; 
				}
			}
	    }     
	    request.setAttribute("result", result);
	    PrintWriter out=response.getWriter();
	    out.print("<script language='JavaScript'>alert('"+result+"');window.location.href='importUser.jsp?num="+num+"'</script>");
	}
}
