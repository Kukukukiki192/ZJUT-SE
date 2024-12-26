package com.service;
import java.util.List;
import com.entity.Member;

public interface MemberService{
   public void add(Member member);          // 添加会员
   public void update(Member member);        // 更新会员
   public void delete(long id);                // 删除会员
   public Member findByName(String name,String password);   // 按姓名查找会员
   public Member findById(long id);           // 按id查找会员
   public List<Member> findAll();             // 查找全部会员
}


