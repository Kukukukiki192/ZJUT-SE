package com.action;
import com.opensymphony.xwork2.ActionSupport;
import com.model.User;

public class LoginAction2 extends ActionSupport{
    private User user;
    public User getUser() {
	   return user;
    }
    public void setUser(User user) {
	   this.user = user;
    }
    public String authenticate() { // 登录验证方法
	   if ("admin".equals(user.getUsername())
		         && "admin123".equals(user.getPassword())){
	         return "success";
	   } else {
	         addActionError(getText("error.login"));
	         return "error";
	    }
	 }
       public String logout() { // 退出登录方法
	        return "logout";
       }
  }

