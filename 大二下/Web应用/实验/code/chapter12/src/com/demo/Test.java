package com.demo;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.Student;
import com.util.HibernateUtil;

public class Test{
   public static void main(String[] args) {
	   try{
		     Session session = HibernateUtil.getSession();
		     Transaction tx = session.beginTransaction();
		     // 创建查询对象
		     String query_str="from Student as s";
		     Query query = session.createQuery(query_str);
		     List<Student> list = query.list();
		     for(int i = 0; i < list.size(); i ++){
		         Student stud =(Student)list.get(i);
		         System.out.println("学号: " + stud.getSno());
		         System.out.println("姓名: " + stud.getSname());
		      }

			    tx.commit();  
		        session.close();
			 }catch(HibernateException he){
			       he.printStackTrace();   
			 }

   }
}

