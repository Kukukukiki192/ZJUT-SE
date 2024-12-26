package cn.edu.zjut.java.ch06;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<Student>  set = new HashSet<Student>();
 
		set.add(new Student("1000", "Jack")); 
		set.add(new Student("1000", "Jack"));
		set.add(new Student("1000", "Jack"));
		set.add(new Student("1000", "Jack"));
		
		System.out.println(set);
	}
}
class Student{
	
	String id;
	String name;
	
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * ʹ��Set�����Զ������и���Object���е�equals��hashCode������
	 */
	@Override
	public boolean equals(Object obj) { 
		Student o = (Student)obj;
		return this.id.equals(o.id);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * ʹ��Set�����Զ������и���Object���е�equals��hashCode������
	 */
	@Override  
	public int hashCode() { 
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}