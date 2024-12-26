package com.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import com.entity.Member;
import com.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
public class MemberQueryAction extends ActionSupport{
   private MemberService memberService;
// 注入业务逻辑组件
public void setMemberService(MemberService memberService){
      this.memberService = memberService;
}
public String execute(){
      List<Member> list = memberService.findAll();
       // 将所有会员信息存入request作用域中
      ServletActionContext.getRequest().setAttribute("memberList",list);
      return SUCCESS;
}
}

