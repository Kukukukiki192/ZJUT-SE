package com.model;

public class Class {
	public String Bno;
	public String Bname;
	public String Mno;
	public Class() {
		super();
	}
	public Class(String bno, String bname, String mno) {
		super();
		Bno = bno;
		Bname = bname;
		Mno = mno;
	}
	public String getBno() {
		return Bno;
	}
	public void setBno(String bno) {
		Bno = bno;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getMno() {
		return Mno;
	}
	public void setMno(String mno) {
		Mno = mno;
	}
}
