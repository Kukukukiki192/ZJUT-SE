package com.hibernate;
public class Student {	
	private Integer id;
    private String sno; 
    private String sname; 
    private int sage;
    private String major;  
    public Student() { }
    public Student(String sno, String sname, int sage,
			String major){
	this.sno = sno;
	this.sname = sname;
	this.sage = sage;
	this.major = major;
    }
    // 这里省略属性的getter和setter方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
    
}

