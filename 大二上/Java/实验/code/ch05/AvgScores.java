package cn.edu.zjut.java.ch05;

public class AvgScores {
	public static void main(String args[]) {
		String names[] = { "�Ź���", "����", "����" }; // ��λͬѧ������
		// ���ſγ̵ĳɼ�
		int[][] iScores = { { 89, 98, 87 }, { 90, 88, 95 }, { 86, 92, 93 } };
		for (int i = 0; i < iScores.length; i++) {
			double avg = 0.0; // ��ʼ��ÿ��ͬѧ��ƽ���ɼ�
			int count = 0;
			for (int j = 0; j < iScores[i].length; j++) {
				avg += iScores[i][j]; // ����avg�������ſγ̵��ܺ�
				count++;
			} // for j
			avg = avg / count; // ��ʱ��j��ʾһ���м��ſ�
			System.out.printf("%s:%2.0f\n", names[i], avg); // ��ʽ����� 

		} // for i
	} // main
}
