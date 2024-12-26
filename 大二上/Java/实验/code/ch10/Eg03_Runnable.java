package cn.edu.zjut.java.ch10;

/**
 * �� Runnable ��ʵ��������һ���̶߳���
 */

public class Eg03_Runnable implements Runnable {
	private int ticket = 10;

	public void run() {
		while (this.ticket > 0) {
			try {
				// Ϊ����ʾ���߳�������˯��һ��
				Thread.sleep(100); // ���ڹ�����Դʵ�ֵĻ�������sleep���п��ܵ��³��ֳ��ָ������Լ�10,9,8.����1���ǰ���˳������
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // ˯�߽����󣬼�����ǰ��Ʊ��������
			
			// ������Ʊ��һֱ��ʣ��Ʊ��Ϊ0��
			System.out.println(Thread.currentThread().getName() + "��Ʊ-->"
					+ (this.ticket--));
		}
	} // ����������Ʊ���ڵ��߳�����ģ�ⴰ����Ʊ

	public static void test01() {
		// �����߳���
		Eg03_Runnable t1 = new Eg03_Runnable();
		Eg03_Runnable t2 = new Eg03_Runnable();
		Eg03_Runnable t3 = new Eg03_Runnable();

		// �����߳�
		Thread t1s = new Thread(t1);
		Thread t2s = new Thread(t2);
		Thread t3s = new Thread(t3);

		// ���߳�����
		t1s.setName("����1");
		t2s.setName("����2");
		t3s.setName("����3");

		// �߳�����
		t1s.start();
		t2s.start();
		t3s.start();
	}

	public static void test02() {
		// �����߳���
		Eg03_Runnable t1 = new Eg03_Runnable();

		// �����߳�
		Thread t1s = new Thread(t1);
		Thread t2s = new Thread(t1);
		Thread t3s = new Thread(t1);

		// ���߳�����
		t1s.setName("����1");
		t2s.setName("����2");
		t3s.setName("����3");

		// �߳�����
		t1s.start();
		t2s.start();
		t3s.start();
	}

	static public void main(String args[]) {
		//test01();
		test02();
	}
}
