package com.entity; 
import java.util.Set;
import java.util.HashSet;
public class Course{ 
    private Long id; 
    private String courseName; 
    private double ccredit; 
    private Set<Student> students = new HashSet<Student>();
 
    public Course() { 
    } 
    public Course(String courseName,double ccredit) { 
       this.courseName = courseName; 
        this.ccredit = ccredit;
    } 
    public Long getId() { 
       return id; 
    }       
    public void setId(Long id) { 
       this.id = id; 
    }       
    public String getCourseName() { 
       return this.courseName; 
    }       
    public void setCourseName(String courseName) { 
       this.courseName = courseName; 
    } 
    public double getCcredit() { 
       return this.ccredit; 
    }       
    public void setCcredit(double ccredit) { 
       this.ccredit = ccredit; 
    }
  public void setStudents(Set<Student> students){
       this. students = students;
}
public Set<Student> getStudents(){
       return students;
}
}

