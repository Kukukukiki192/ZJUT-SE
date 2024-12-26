package cn.edu.zjut.java.ch04;

import java.util.ArrayList;
import java.util.Collections;


public class ComparableSort {

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student ("111", "a a"));
		list.add(new Student ("333", "c c"));
		list.add(new Student ("222", "b b"));
		Collections.sort(list); 
		
		for(Student s : list){
			System.out.println(s.id + "   " + s.name);
		}
	}
}

class Student implements Comparable{

	String id;
	String name;
	
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Object arg0) {
		Student s = (Student) arg0;
		return id.compareTo(s.id);
	 
	}
	
	
}
