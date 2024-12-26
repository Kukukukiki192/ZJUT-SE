package cn.edu.zjut.java.ch04;

public class ChildClassIntheSamePackage extends FatherClass {

	
	
	public void testF(){
		 
	}
	
	public static void main(String[] args) {
		
		FatherClass a = new FatherClass();
		
		a.defaultVariable = 10;
		a.protectedVariable = 0;
		//a.privateVariable = 10;
		a.publicVariable = 10;
		
		
	}

}
 