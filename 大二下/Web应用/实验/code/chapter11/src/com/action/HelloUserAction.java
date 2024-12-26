package com.action;
import com.opensymphony.xwork2.ActionSupport;

public class HelloUserAction extends ActionSupport {
	    private String message;       // 动作属性
	    public String getMessage() {
		   return message;
	    }
	    public void setMessage(String message) {
		   this.message = message;
	    }
	    private String userName;
	    public String getUserName() {
	    	return userName;
	    }
	    public void setUserName(String userName) {
	    	this.userName = userName;
	    }

	    @Override
        public String execute() throws Exception {
	    	setMessage("Hello Struts User");
	    	setMessage(getMessage() + " " + userName);
	    	
		   return SUCCESS;
	    }
}

