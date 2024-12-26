package com.entity;

import java.util.*;
public class Department {
   private Long id;
   private String deptName;
   private String telephone;
   private Set<Employee> employees; //  引用员工的集合属性
   public Department(){}    // 默认构造方法
   public Department(String deptName, String telephone, 
                     Set<Employee> employees){
      this.deptName = deptName;
      this.telephone = telephone;
      this.employees = employees;
   }
   // employees属性的getter和setter方法
   public Set<Employee> getEmployees(){
       return employees;
   }
public void setEmployees(Set<Employee> employees){
   this.employees = employees;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
} 

   // 省略其他属性的getter和setter方法
}

