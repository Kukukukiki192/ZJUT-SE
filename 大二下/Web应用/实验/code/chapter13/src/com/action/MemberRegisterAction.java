package com.action;
import com.entity.Member;
import com.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
public class MemberRegisterAction extends ActionSupport{
   private Member member;
   private MemberService memberService;
   public void setMember(Member member){
      this.member = member;
   }
   public Member getMember(){
      return member;
   }
   // 注入业务逻辑组件
   public void setMemberService(MemberService memberService){
      this.memberService = memberService;
   }
   public String execute(){
      //System.out.println("Member.ID="+member.getId());
      memberService.add(member);
      return SUCCESS;
   } 
}

