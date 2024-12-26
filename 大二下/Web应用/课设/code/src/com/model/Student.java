package com.model;

public class Student extends User{
	private String Major;
	private String Clas;
	public Student() {
		super();
	}
	public Student(String name, String iD, String num, String psw, String institute, String major, String clas) {
		super(name,iD,num,psw,institute);
		Major = major;
		Clas = clas;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getClas() {
		return Clas;
	}
	public void setClas(String clas) {
		Clas = clas;
	}	
}