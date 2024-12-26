package cn.edu.zjut.java.ch10;

/**
 * ���ַ�ʽʵ��ͬ���� synchronized void methodA() { }
 * 
 * ʹ��ͬ���� synchronized(obj){ obj�Ǳ������Ķ��� Ҫͬ������� }
 */

public class Eg08_SynchronizedThread implements Runnable {
	// һ����10��Ʊ
	private int ticket = 10;

	public void run() {
		while (true) { // ������Ʊ��һֱ��ʣ��Ʊ��Ϊ0��
			synchronized (this) {  //TODO ɾ���������Կ�
				if (ticket > 0) {
					try {
						// Ϊ����ʾ���߳�������˯��һ��
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // ˯�߽����󣬼�����ǰ��Ʊ��������
					System.out.println(Thread.currentThread().getName()
							+ "��Ʊ-->" + (this.ticket--));
				} else {
					break;
				}
			}
		}
	}
	
//	public void run(){ 
//		while(ticket>0) {//������Ʊ��һֱ��ʣ��Ʊ��Ϊ0
//			sell();
//		}
//	}

	public synchronized void sell() {
		if (ticket > 0) {
			try {
				// Ϊ����ʾ���������⣬�߳�������˯��һ��
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ˯�߽����󣬼�����ǰ��Ʊ��������
			System.out.println(Thread.currentThread().getName() + "��Ʊ-->"
					+ (this.ticket--));
		}
	}

	// ����������Ʊ���ڵ��߳�����ģ�ⴰ����Ʊ
	static public void main(String args[]) {
		Eg08_SynchronizedThread ru = new Eg08_SynchronizedThread();

		Thread t = new Thread(ru); // �½��߳�
		t.setName("����1");// �߳�����
		Thread t1 = new Thread(ru);
		t1.setName("����2");
		Thread t2 = new Thread(ru);
		t2.setName("����3");

		
		//��ͻ�����Ӽ���Eg03_Runnable.java
		t.start();// �߳�����
		t1.start();
		t2.start();
	}
}
