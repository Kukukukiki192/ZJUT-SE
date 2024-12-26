package com.model;

public class Teacher {
	public String Tno;
	public String Tname;
	public String Tsex;
	public Integer Tage;
	public String title;
	public String phone;
	public Teacher() {
		super();
	}
	public Teacher(String tno, String tname, String tsex, Integer tage, String title, String phone) {
		super();
		Tno = tno;
		Tname = tname;
		Tsex = tsex;
		Tage = tage;
		this.title = title;
		this.phone = phone;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTsex() {
		return Tsex;
	}
	public void setTsex(String tsex) {
		Tsex = tsex;
	}
	public Integer getTage() {
		return Tage;
	}
	public void setTage(Integer tage) {
		Tage = tage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
