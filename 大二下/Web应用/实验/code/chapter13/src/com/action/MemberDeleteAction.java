package com.action;
import com.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
public class MemberDeleteAction extends ActionSupport{
   private MemberService memberService;
// 注入业务逻辑组件
public void setMemberService(MemberService memberService){
     this.memberService = memberService;
}
private long id;
public long getId(){
     return id;
}
public void setId(long id){
     this.id = id;
}
public String execute(){
    memberService.delete(getId());
    return SUCCESS;
  }
}

