package com.action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class IteratorAction extends ActionSupport{
   private List<String> fruit;
   private Map<String,String> country;
   
   public String execute()throws Exception{
	  fruit = new ArrayList<String>();
	  fruit.add("苹果");
	  fruit.add("橘子");
	  fruit.add("香蕉");
	  fruit.add("草莓");
      country = new HashMap<String,String>();
      country.put("China", "北京");
      country.put("USA", "纽约");
      country.put("England", "伦敦");
      country.put("Russia", "莫斯科");
     return SUCCESS;
   }
   public List<String> getFruit(){
       return fruit;
   }
   public Map<String,String> getCountry(){
	  return country;
   }
}

