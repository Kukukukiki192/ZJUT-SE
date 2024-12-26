package com.entity;

import java.util.Calendar;
public class Employee{
   private Long id;
   private String employeeNo;
   private String employeeName;
   private char gender;
   private Calendar birthdate;
   private double salary;
   public Employee(){
   }
   
  public Employee(String employeeNo, String employeeName, char gender,
		          Calendar birthdate,double salary) {
	this.employeeNo = employeeNo;
	this.employeeName = employeeName;
	this.gender = gender;
	this.birthdate = birthdate;
	this.salary = salary;
  }

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmployeeNo() {
	return employeeNo;
}
public void setEmployeeNo(String employeeNo) {
	this.employeeNo = employeeNo;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
public Calendar getBirthdate() {
	return birthdate;
}
public void setBirthdate(Calendar birthdate) {
	this.birthdate = birthdate;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

private Department department;
  public Department getDepartment(){
    return this.department;
  }
  public void setDepartment(Department department){
    this.department = department;
  }
}
