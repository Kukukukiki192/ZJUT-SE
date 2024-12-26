package cn.edu.zjut.java.ch03;

public class FinalTest {

	private final long StudentID;

	public FinalTest(){
		StudentID = 1;
	}
	
//	public void f(){
//		StudentID = 11;
//	}
	
	public static void main(String[] args){
		
		
		final int[] value = {1,2,3};
//		int[] another = {4,5,6};
//		value = another;
		
		
	
		
		final Student stu1 = new Student(22, "Tom");
		Student stu2 = new Student(25, "Jerry");

		///stu1 = stu2; // 编译出错
		System.out.println("stu1的name:" + stu1.name + "; stu1的age:" + stu1.age);

		stu1.setName("Jerry");
		stu1.setAge(25);

		// 这时stu1指向的对象发生了改变
		System.out.println("stu1的name:" + stu1.name + "; stu1的age:" + stu1.age);

		
	}
}
