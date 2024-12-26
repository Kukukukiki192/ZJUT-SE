package com.action; 
import com.model.User;

public class SampleAction { 
    private String message;
    private  User user = new User(); 
    {
        user.setUsername("王小明");   // 初始化块
    }

    public String getMessage(){ 
       return message; 
    }
    public void setMessage(String message){ 
       this.message = message; 
    }
    public User getUser() { 
       return user; 
   }
    public void setUser(User user) { 
       this.user = user; 
    } 
    private String[] cities;
    
    public String[] getCities() {
		return cities;
	}
	public void setCities(String[] cities) {
		this.cities = cities;
	}
	public String execute() {
	   //    setMessage("世界，你好！");
       cities = new String[]{"北京","上海","天津","重庆"};
        return "success"; 
    } 
}

