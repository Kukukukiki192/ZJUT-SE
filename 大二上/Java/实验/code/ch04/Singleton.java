package cn.edu.zjut.java.ch04;

public class Singleton {

	private static Singleton instance = null;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if( instance == null){
			instance =  new Singleton();
		}
		return instance;
	}
	
	@Override
	public String toString() {
		return "Singleton []";
	}

	public static void main(String[] args) {
		Singleton a1 = Singleton.getInstance();
		Singleton a2 = Singleton.getInstance();
		System.out.println(a1 == a2);
		
		System.out.println(a1.toString());
	}

}
	