package com.action;
import org.hibernate.Session;
import com.entity.Member;
import com.util.HibernateUtil;

public class Main { 
	public static void main(String[] args) {
        // 创建会话对象
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        // 开始一个事务
        session.beginTransaction();
        // 创建一Student对象
        Member mb  = new Member();
        
        mb = (Member)session.get(Member.class, new Long(1));
        
        System.out.println(mb);
        session.delete(mb);
        session.getTransaction().commit();            // 提交事务
        HibernateUtil.getSessionFactory().close();      //  关闭会话工厂

	}
}

