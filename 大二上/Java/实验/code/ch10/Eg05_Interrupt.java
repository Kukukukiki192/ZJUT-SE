package cn.edu.zjut.java.ch10;

/**
 * interrupt�������ж��̵߳�����
 */

public class Eg05_Interrupt extends Thread {
	public void run() {
		long start = System.nanoTime();
		System.out.println("�߳�˯��");
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("�̱߳�����");
		}
		
		long end = System.nanoTime();
		System.out.println("�ܵ�����ʱ��:" + (end - start) / 1000000 + "����");
	}

	public static void main(String[] arg) {
		Eg05_Interrupt t1 = new Eg05_Interrupt();
		t1.start();
		
		t1.interrupt();   //��ʾ�������ж���ʱ���أ���
	}
}
