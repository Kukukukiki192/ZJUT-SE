package cn.edu.zjut.java.ch10;

class Thread1 extends Thread {
	int i = 0;

	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) { // �߳����е�3�ı�����ʱ���ò�һ��
				System.out.println(Thread.currentThread().getName() + "��" + i
						+ "�����У��ò�");
				Thread.yield();// �߳��ò�
			} else {
				System.out.println(Thread.currentThread().getName() + "��" + i
						+ "������");
			}
		}
	}
}

public class Eg06_Yield {
	static public void main(String args[]) {
		Thread1 t1 = new Thread1();// ���������̶߳���
		t1.setName("��һ���߳�");// �߳�����
		Thread1 t2 = new Thread1();
		t2.setName("�ڶ����߳�");
		Thread1 t3 = new Thread1();
		t3.setName("�������߳�");
		t1.start();// �����߳�
		t2.start();
		t3.start();
	}
}
