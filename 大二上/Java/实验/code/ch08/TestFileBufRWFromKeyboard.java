package cn.edu.zjut.java.ch08;


import java.io.*;

/**
 * �����������ڿ���̨�����ַ�(��������)��
 * ������������ִ洢��ָ�����ļ��У�
 * ���Ҫ������������quit�ַ������ɡ�
 */

public class TestFileBufRWFromKeyboard {
	public static void main(String[] args) {
		try {
			String desFile = "out.txt";
			// ����System.in������
			// System.in���ֽ�����ͨ��InputStreamReader����ת��Ϊ�ַ���
			BufferedReader bufReader = new BufferedReader(
					new InputStreamReader(System.in));
			// ����FileWriter
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter(
					desFile));

			String input = null;

			// ÿ��һ�н���һ��д�붯��
			while (!(input = bufReader.readLine()).equals("quit")) {
				bufWriter.write(input);
				/* newLine()����д�������ϵͳ�����Ļ����ַ�����ִ�л�����ʱ��OS��������������ֻ����ַ� */
				bufWriter.newLine();
			}
			bufReader.close();
			bufWriter.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
}
