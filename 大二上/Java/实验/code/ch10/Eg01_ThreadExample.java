package cn.edu.zjut.java.ch10;

public class Eg01_ThreadExample extends Thread {
	//ʵ���˽ӿڵ�run����
	public void run() { 
		System.out.println("�߳�������");
	}
	
	public static void main(String args[]) {
		Eg01_ThreadExample t = new Eg01_ThreadExample();

		t.start();
	}
}

