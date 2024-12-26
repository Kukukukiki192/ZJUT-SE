package com.action;
import com.entity.Member;
import com.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
public class MemberUpdateAction extends ActionSupport{
   private MemberService memberService;
   private Member member;
   // 用于接收从现实会员信息页面传递来的id
   private long id;
   // 注入业务逻辑组件
   public void setMemberService(MemberService memberService){
      this.memberService = memberService;
   }
   public Member getMember(){
      return member;
   }
   public void setMember(Member member){
      this.member = member;
   }
   public long getId() {
	 return id;
   }
   public void setId(long id) {
	 this.id = id;
   }
   public String showMember(){
	 System.out.println("会员号="+getId());
	  Member mb = memberService.findById(getId());
      setMember(mb); 
      System.out.println("会员名="+member.getName());
      return SUCCESS;
	}


  public String execute(){
      memberService.update(member);
      return SUCCESS;
   }
}

