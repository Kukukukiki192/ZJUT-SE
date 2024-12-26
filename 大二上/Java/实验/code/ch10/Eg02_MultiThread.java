package cn.edu.zjut.java.ch10;

public class Eg02_MultiThread extends Thread {
	int ticket = 10;

	// ��дThread���run()������
	public void run() {
		// ������Ʊ��һֱ��ʣ��Ʊ��Ϊ0��
		while (this.ticket > 0) {
			System.out.println(this.getName() + "��Ʊ-->" + (this.ticket--));
		}
	}

	static public void main(String args[]) {
		// ����������Ʊ���ڵ��߳�����ģ�ⴰ����Ʊ
		Eg02_MultiThread t1 = new Eg02_MultiThread();
		Eg02_MultiThread t2 = new Eg02_MultiThread();
		Eg02_MultiThread t3 = new Eg02_MultiThread();

		// ���߳�����
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");

		// �߳�����
		t1.start();
		t2.start();
		t3.start();
	}

}
