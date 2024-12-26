package com.demo;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.Student;
public class MainApp { 
	public static void main(String[] args) {
	    // 加载配置文件hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
	    // 创建会话工厂对象
        SessionFactory  factory = configuration.buildSessionFactory(); 
	    // 创建会话对象
        Session session = factory.openSession();
	    // 创建一个事务对象
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setSno("20180108"); 
        student.setSname("王小明");
        student.setSage(20);
        student.setMajor("计算机科学");
        session.save(student);  // 将student对象持久化到数据表中
        System.out.println("插入学生成功！"); 
        // 从数据库中读取一个对象
        Student stud = (Student)session.get(Student.class, new Integer(1));
        System.out.println(stud.getSno() + "\n"+stud.getSname() 
                           + "\n" + stud.getSage());
        tx.commit();  // 提交事务
        session.close();
        factory.close();
	}
}

