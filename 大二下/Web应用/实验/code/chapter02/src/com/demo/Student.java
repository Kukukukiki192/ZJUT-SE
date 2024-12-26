package com.demo;
public class Student {
    private String sno;
    private String name;
    public Student(String sno, String name) {
		 this.sno = sno;
		 this.name = name;
	    }
	    // 省略属性的setter方法和getter方法
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

