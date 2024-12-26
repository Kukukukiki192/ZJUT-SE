package cn.edu.zjut.java.ch04;


public class FatherClass {

	int defaultVariable;
	
	private int privateVariable;
	
	protected int protectedVariable;
	
	public int publicVariable;
	
	public  void publicF(){		
	}
	protected void protectedF(){		
	}
	
	private void privateF(){
		
	}
	
	public static void main(String[] args) {

		FatherClass at = new FatherClass();
		at.protectedVariable = 0;
		at.privateVariable = 1;
		
	}

}