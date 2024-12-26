package com.model;

public class City {
   private int id;        // 城市号 
   private String name;   // 城市名
  
   public City(int id, String name) {
	 this.id = id;
	 this.name = name;
   }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   
}
