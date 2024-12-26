package cn.edu.zjut.java.ch04.subch01;

import cn.edu.zjut.java.ch04.FatherClass;

public class ChildClassInAnotherPackage extends FatherClass {

	public static void main(String[] args) {
		
		FatherClass a = new FatherClass();
		
		//a.protectedVariable = 0;
		
		
		ChildClassInAnotherPackage a2 = new ChildClassInAnotherPackage();
		
		a2.protectedVariable = 0;
		
	}

}
