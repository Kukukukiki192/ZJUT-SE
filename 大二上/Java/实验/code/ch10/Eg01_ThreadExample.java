package cn.edu.zjut.java.ch10;

public class Eg01_ThreadExample extends Thread {
	//实现了接口的run方法
	public void run() { 
		System.out.println("线程在运行");
	}
	
	public static void main(String args[]) {
		Eg01_ThreadExample t = new Eg01_ThreadExample();

		t.start();
	}
}

