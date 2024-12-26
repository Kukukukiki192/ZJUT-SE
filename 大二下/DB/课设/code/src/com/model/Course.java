package com.model;

public class Course {
	public String Cno;//课程编号
	public String Cname;//课程名称
	public String Tname;//教师姓名
	public String period;//开课时间
	public Integer hour;//课程学时
	public String test;//考核方式
	public Integer credit;//学分
	public Course() {
		super();
	}
	public Course(String cno, String cname, String tname, String period, Integer hour, String test, Integer credit) {
		super();
		Cno = cno;
		Cname = cname;
		Tname = tname;
		this.period = period;
		this.hour = hour;
		this.test = test;
		this.credit = credit;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
}
