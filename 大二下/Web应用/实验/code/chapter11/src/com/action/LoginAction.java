package com.action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;

@Validations
public class LoginAction extends ActionSupport {
   private String username;
   private String password;
   public String execute() throws Exception{
      if (this.username.equals("admin")
              && this.password.equals("admin123")) {
          return "success";
       } else {
            addActionError("用户名或口令错误，请重新输入！");
          return "input";
     }
   }
   @RequiredStringValidator(message="请输入用户名")
   public String getUsername() {
       return username;
    }
   public void setUsername(String username) {
      this.username = username;
   }
   @RequiredStringValidator(message="请输入口令")
   public String getPassword() {
       return password;
    }
   public void setPassword(String password) {
      this.password = password;
   }
}

