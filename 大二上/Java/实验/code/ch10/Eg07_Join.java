package cn.edu.zjut.java.ch10;

/**
 * join()��������һ���̵߳ȴ���һ���̵߳���ɣ�����t1��t2�������̶߳���
 * ��t1�е�����t2.join()���ͻᵼ��t1�߳���ִͣ�У�
 * һֱ�ȴ���t2�߳�����ˣ�t1�Ż�ָ�ִ�С�
 */

public class Eg07_Join extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {// �߳�ѭ��10������ַ�
			System.out.println(Thread.currentThread().getName() + "��" + i
					+ "�����");
		}
		System.out.println(Thread.currentThread().getName() + "���н���");
	}

	public static void main(String[] arg) {
		System.out.println("�����̡߳���ʼ����");// main���߳̿�ʼ����
		Eg07_Join t = new Eg07_Join();
		t.setName("�߳�1");// ���߳�����
		
		try {
			long start = System.nanoTime();
			t.start();
			//t.join();// ��main�߳��е�����join����ô�û�ȴ�t�߳�ִ����ϣ��ټ�����
			//����ע�͵����У��������ô���ӵģ���
			// ����t�߳������˶���ʱ��
			long end = System.nanoTime();
			System.out.println("��" + t.getName() + "����ʱ" + (end - start) / 1000000 + "����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����̡߳����н���");// ���߳����н���
	}
}
