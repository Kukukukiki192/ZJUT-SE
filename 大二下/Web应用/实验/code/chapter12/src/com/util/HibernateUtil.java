package com.util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private static SessionFactory factory;   
    static{
	   try{
		  Configuration configuration = new Configuration().configure();
          factory = configuration.buildSessionFactory(); 
	   }catch(HibernateException e){
		  e.printStackTrace();
	   }
   }
  // 返回会话工厂对象
  public static SessionFactory getSessionFactory() {
      return factory;
  }
  // 返回一个会话对象
  public static Session getSession() {
      Session session = null;
      if(factory !=null)
    	      session = factory.openSession();
	  return session;
  }
  // 关闭指定的会话对象
  public static void closeSession(Session session){
	 if(session !=null){
		 if(session.isOpen())
			 session.close();
	 }
  }
}

