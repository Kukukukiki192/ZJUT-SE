package com.listener;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener{
   private int count = 0;
//   private String time=LocalTime.now(),IP=request.remoteAddr;
   
   public void requestInitialized(ServletRequestEvent re){
      HttpServletRequest request= (HttpServletRequest)re.getServletRequest();
      if(request.getRequestURI().endsWith("onlineCount.jsp")){
    	  //将客户端的访问记录（包括IP、访问时间）保存至数据库中，要求同一个IP只能记录一次
    	  //得到客户端IP，若该IP已在List对象或数据库中，则不增加访问次数，否则访问次数加1，并将该IP加到List对象或数据库中
         count++;
         String requestUrlIP = request.getServerName();
    	 String userIpAddr = request.getRemoteAddr();
    	 System.out.println("***访问的Url中的服务器IP："+requestUrlIP);
    	 System.out.println("***用户客户端的IP地址："+userIpAddr);
    	 Date t = new Date();
	   	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   	 String time=df.format(t);
    	 System.out.println(time);
    	 System.out.println(t);
    	 re.getServletContext().setAttribute("time",time);
         re.getServletContext().setAttribute("count",count);
      } 
   }  
   public void requestDestroyed(ServletRequestEvent re){
   }
}
