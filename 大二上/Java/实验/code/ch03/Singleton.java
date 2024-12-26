package cn.edu.zjut.java.ch03;

public class Singleton {

	private static Singleton instance;

	int a = 10;
	
	
	/**
	 * May test this cons in other class. 
	 */
	private Singleton() {
		
	}
	

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.a ++;

		Singleton s2 = Singleton.getInstance();
		s2.a ++;
		
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s3.a);
		
	}

}
