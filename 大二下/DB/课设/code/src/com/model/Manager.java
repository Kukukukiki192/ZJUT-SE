package com.model;

public class Manager {
	public String 
	Sno,
	Sname,
	Cno,
	Cname,
	Bno,
	Bname,
	Tno,
	Tname,
	period;//学期
	public Integer
	credit,//各科学分
	credits,//总学分
	score,
	avgscore,//各科平均成绩
	hour;//课程学时
	public Manager() {
		super();
	}
	public Manager(String sno, String sname, String cno, String cname, String bno, String bname, String tno, String tname,
			String period, Integer credit, Integer credits, Integer score, Integer avgscore, Integer hour) {
		super();
		Sno = sno;
		Sname = sname;
		Cno = cno;
		Cname = cname;
		Bno = bno;
		Bname = bname;
		Tno = tno;
		Tname = tname;
		this.period = period;
		this.credit = credit;
		this.credits = credits;
		this.score = score;
		this.avgscore = avgscore;
		this.hour = hour;
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(Integer avgscore) {
		this.avgscore = avgscore;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
}