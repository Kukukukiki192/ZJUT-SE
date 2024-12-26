package com.model;

public class Student {
	public String Sno;
	public String Sname;
	public String Ssex;
	public Integer Sage;
	public String address;//生源地
	public Integer credits;//已修学分总数
	public String Bno;//班级编号
	public Student() {
		super();
	}
	public Student(String sno, String sname, String ssex, Integer sage, String saddress, Integer credits, String bno) {
		super();
		Sno = sno;
		Sname = sname;
		Ssex = ssex;
		Sage = sage;
		address = saddress;
		this.credits = credits;
		Bno = bno;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public Integer getSage() {
		return Sage;
	}
	public void setSage(Integer sage) {
		Sage = sage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String saddress) {
		address = saddress;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public String getBno() {
		return Bno;
	}
	public void setBno(String bno) {
		Bno = bno;
	}
}
