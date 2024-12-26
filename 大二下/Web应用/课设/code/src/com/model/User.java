package com.model;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

//姓名、身份证号、学号或工号、密码、学院
public class User {
	 private String Name;
	 private String ID;
	 private String Num;
	 private String Psw;
	 private String Institute;
	 private String Phone;
	 private String Code;	
	 private Integer Clockin;	//今日打卡情况
	 private Integer Day;		//连续打卡天数
	 private String Date;		//上次打卡日期

	public User() {
		super();
	}
	public User(String name, String iD, String num, String psw, String institute) {
		super();
		Name = name;
		ID = iD;
		Num = num;
		Psw = psw;
		Institute = institute;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getPsw() {
		return Psw;
	}
	public void setPsw(String psw) {
		Psw = psw;
	}
	public String getInstitute() {
		return Institute;
	}
	public void setInstitute(String institute) {
		Institute = institute;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public Integer getClockin() {
		return Clockin;
	}
	public void setClockin(Integer clockin) {
		Clockin = clockin;
	}
	public Integer getDay() {
		return Day;
	}
	public void setDay(Integer day) {
		Day = day;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Date StringtoDate() {		
        //获得SimpleDateFormat类,转换为yyyy-MM-dd的时间格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {//使用SimpleDateFormat的parse()方法生成Date
            Date date = sf.parse(Date);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }       
	}
	public void DateToString(Date date){		
        // 获得SimpleDateFormat类
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date= sf.format(date);      
	}
}