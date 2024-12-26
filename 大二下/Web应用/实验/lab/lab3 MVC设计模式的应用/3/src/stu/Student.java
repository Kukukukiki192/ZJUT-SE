package stu;

public class Student {
	 private String stuid;
	 private String name;
	 private String major;
	public Student() {
		super();
	}
	public Student(String stuid, String name, String major) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.major = major;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}