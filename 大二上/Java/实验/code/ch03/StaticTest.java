package cn.edu.zjut.java.ch03;

public class StaticTest{
	public static void main(String[] args){
		StaticTest2.f();
	}
}

class StaticTest2 {
	
	static int num;
	
	static void f(){
		System.out.println(num);
	}
	
	void gFromAnotherUser(){
	}
	
	public static void main(String[] args) {
		f();
	}
}
