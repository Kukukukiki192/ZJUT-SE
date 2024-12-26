package cn.edu.zjut.java.ch03;

public class Student {
	String name;
	char sex;
	int stuID;
	int age;
	public static int totalNumber = 0; // 学生的总数
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", stuID=" + stuID + ", age=" + age + "]";
	}
	public Student() {
		totalNumber++;
	}
	public Student(String stuName, char sex, int stuID) {
		name = stuName;
		this.sex = sex;
		this.stuID = stuID;
		sex = '1';
		totalNumber++;
	}
	public Student(int age, String stuName) {
		name = stuName;
		this.age = age;
		totalNumber++;
	}
	public static void printMotto() {
		System.out.println("I have a dream.");
	}
	public static void statTotalNumber() {
		System.out.println("学生的总数是：" + totalNumber);
	}
	
	public static void main(String args[]) {
		
		int globalNumer  = 0;
		
		Student a = new Student();
		globalNumer++;
		a.name = "";
		
		Student[] s = new Student[30];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Student();
			globalNumer++;
		}

		statTotalNumber();

		// Student s1=new Student();
		// s1.name = "kk";
		// printMotto();
		//

		//
		// s1.setName("张三");
		// s1.setSex('男');
		// s1.setStuID(20080201);
		//
		// Student s2=new Student("李四", '男',20080301);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getStuID() {
		return stuID;
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int getTotalNumber() {
		return totalNumber;
	}

	public static void setTotalNumber(int totalNumber) {
		Student.totalNumber = totalNumber;
	}

}

// class StaticMethodSupClass{
// public void methodOne(int i){}
// public void methodTwo(int i){}
// public static void methodThree(int i){}
// public static void methodForth(int i){}
// }
//
// class StaticMethodSubClass extends StaticMethodSupClass{
// public static void methodOne(int i){}
// public void methodTwo(int i){}
// public void methodThree(int i){}
// public static void methodForth(int i){}
// }
