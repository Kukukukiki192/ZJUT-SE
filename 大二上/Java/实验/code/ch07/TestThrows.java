package cn.edu.zjut.java.ch07;

import java.io.IOException;

public class TestThrows {

	public static void main(String[] args) {
		
		
		try {
			method();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 调用method()方法时，必须捕获异常
		
		
		
//		try {
//			method();
//		} catch (IOException ioe) {// 捕获IOException异常
//			// …
//		}
		
	}

	public static void method() throws IOException{  //changing to Exception or ArithmeticException will print a
			int a =  10 / 0; 
	}

}
