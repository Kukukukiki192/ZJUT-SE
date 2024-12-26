package com.demo;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.Student;
import com.util.HibernateUtil;

public class StudentDemo{
   public static void main(String[] args) {
	   try{
		     Session session = HibernateUtil.getSession();
		     Transaction tx = session.beginTransaction();
		     // 创建查询对象
		Query query = session.createQuery("from Student s");
		List<Student> students = (List<Student>)query.list();
		     for (int i = 0; i < students.size(); i++) {
		        Student student = (Student)students.get(i);
		          System.out.println("学号:" + student.getSno() +
		"\t姓名:" + student.getSname()+
			          		            "\t年龄:" + student.getSage()+
			          		            "\t专业："+student.getMajor());
			    }
			    tx.commit();  
		        session.close();
			 }catch(HibernateException he){
			       he.printStackTrace();   
			 }

   }
}

