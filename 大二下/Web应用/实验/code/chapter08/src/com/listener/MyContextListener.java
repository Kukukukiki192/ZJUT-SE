package com.listener;
import javax.sql.*;
import java.time.LocalTime;
import javax.servlet.*;
import javax.naming.*;
import javax.servlet.annotation.WebListener;

@WebListener     // 使用注解注册监听器
public class MyContextListener  implements ServletContextListener, 
ServletContextAttributeListener{
   private ServletContext context = null;
   public void contextInitialized(ServletContextEvent sce){
    Context ctx = null;
       DataSource dataSource = null;
       context = sce.getServletContext();
       try{
         if(ctx == null){
       	  ctx = new InitialContext();
         }
        dataSource = 
           (DataSource)ctx.lookup("java:comp/env/jdbc/webstoreDS");
      }catch(NamingException ne){
     	context.log("发生异常:"+ne);
      }
   	 context.setAttribute("dataSource",dataSource);   // 添加属性
   	 context.log("应用程序已启动："+ LocalTime.now());
   }
   public void contextDestroyed(ServletContextEvent sce){
       context = sce.getServletContext();
       context.removeAttribute("dataSource");
   	  context.log("应用程序已关闭："+ LocalTime.now());
   }
   public void attributeAdded(ServletContextAttributeEvent sce){
   	 context = sce.getServletContext();
   	 context.log("添加一个属性："+sce.getName()+"："+sce.getValue());
   }
   public void attributeRemoved(ServletContextAttributeEvent sce){
   	 context = sce.getServletContext();
   	 context.log("删除一个属性："+sce.getName()+"："+sce.getValue());
   }
   public void attributeReplaced(ServletContextAttributeEvent sce){
   	 context = sce.getServletContext();
   	 context.log("替换一个属性："+sce.getName()+"："+sce.getValue());
   }
}

