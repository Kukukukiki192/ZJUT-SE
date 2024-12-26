package cn.edu.zjut.java.ch04;

interface InterfaceWithDefault {

	public void doWork();
	
	default public void doSomeWork(){
		 System.out.println("Hello"); 
	}
	
}

public class InterfaceWithDefaultTest implements InterfaceWithDefault{

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		
	}
	
//	public void doSomeWork(){
//		 
//	}
	 
}