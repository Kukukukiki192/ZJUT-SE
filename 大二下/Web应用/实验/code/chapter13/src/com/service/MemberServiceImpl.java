package com.service;
import java.util.List;
import com.entity.Member;
import com.dao.MemberDAO;
public class MemberServiceImpl implements MemberService{
   private MemberDAO memberDao;
   // 注入DAO对象
   public void setMemberDao(MemberDAO memberDao){
      this.memberDao = memberDao;
}
// 添加会员
public void add(Member member){
     // 如果表中不包含该会员，则添加该会员
      if(memberDao.findById(member.getId())==null)
        memberDao.add(member);
}         
// 更新会员   
public void update(Member member){
    // 如果表中存在该会员，则更新该会员
    if(memberDao.findById(member.getId())!=null)
       memberDao.update(member);
}
   // 删除会员
public void delete(long id){
      // 如果表中存在该会员，则删除该会员
    if(memberDao.findById(id)!=null)
         memberDao.delete(id);
    }                
// 按姓名查找会员
   public Member findByName(String name,String password){
      return memberDao.findByName(name,password);
}           
// 按id查找会员
   public Member findById(long id){
      return memberDao.findById(id);
}
// 查找全部会员
public List<Member> findAll(){
      return memberDao.findAll();
}            
}

