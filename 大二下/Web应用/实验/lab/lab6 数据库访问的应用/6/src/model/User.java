package model;
//姓名、身份证号、学号或工号、密码、学院
public class User {
	 private String Name;
	 private String ID;
	 private String Num;
	 private String Psw;
	 private String Institute;
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
}