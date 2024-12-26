package com.action; 
import java.util.Date;

public class TagAction { 
	private Date currentDate;
    
	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String execute() throws Exception{
	     setCurrentDate(new Date());
	     return "success";
	}
}

