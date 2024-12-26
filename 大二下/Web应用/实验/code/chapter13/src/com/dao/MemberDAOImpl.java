package com.dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.entity.Member;

public class MemberDAOImpl implements MemberDAO{
   private SessionFactory sessionFactory;
 
   public MemberDAOImpl(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
   }
    // 使用SessionFactory对象返回Session对象
   private Session currentSession(){
       return sessionFactory.openSession();
   }
   // 添加会员
   public void add(Member member){
	   Session session=null;
	   try{
		  session = currentSession();
		  Transaction tx =session.beginTransaction();
		  System.out.println(member.getId());
		  System.out.println(member.getName());
		  session.save(member);
		  tx.commit();
	  }catch(HibernateException e){
		  e.printStackTrace();
	  }finally{
		  session.close();
	  }
      
}         
   // 更新会员
public void update(Member member){
	Session session=null;
	try{
		 session = currentSession();
		  Transaction tx =session.beginTransaction();
		  session.update(member);
		  tx.commit();
	  }catch(HibernateException e){
		  e.printStackTrace();
	  }finally{
		  session.close();
	  }
      
}       
// 删除会员
   public void delete(long id){
	   Session session=null;
	   try{
		   session = currentSession();
		   Transaction tx =session.beginTransaction();
		   Member mb = (Member)session.get(Member.class, id);
		   session.delete(mb);
		    
		   System.out.println(mb);
		   tx.commit();
		}catch(HibernateException e){
			  e.printStackTrace();
		}finally{
			  session.close();
		}
	   
}                
// 按姓名和口令查找会员
   public Member findByName(String name,String password){
	   Session session=null;
	   Member result=null;
	   try{
		   session = currentSession();
		   Transaction tx =session.beginTransaction();
			String hsql="from Member m where m.name=:mname and m.password=:mpassword";
		    Query query = session.createQuery(hsql);
		    query.setParameter("mname",name);
		    query.setParameter ("mpassword",password);
		    result = (Member)query.uniqueResult();
		    tx.commit();
			  
		  }catch(HibernateException e){
			  e.printStackTrace();
		  }finally{
			  session.close();
		  }
	   return result;
   }    
   // 按id查找会员
public Member findById(long id){
	Session session=null;
	Member result=null;
	try{
		session = currentSession();
		  Transaction tx =session.beginTransaction();   
			String hsql="from Member m where m.id=:id";
		    Query query = session.createQuery(hsql);
		    query.setParameter("id",id);
		    result = (Member)query.uniqueResult();
		    tx.commit();  	    
	  }catch(HibernateException e){
		  e.printStackTrace();
	  }finally{
		  session.close();
	  }
	return result;
}          
// 查找全部会员
public List<Member> findAll(){
	Session session=null;
	List<Member> list = null; 
	
	try{
		session = currentSession();
		Transaction tx =session.beginTransaction();
		String hsql = "from Member";
	    Query query = session.createQuery(hsql);
	    list = query.list();
	    tx.commit(); 
	 }catch(HibernateException e){
		e.printStackTrace();
	 }finally{
		 session.close();
	 }   
     return list;
   }            
}

