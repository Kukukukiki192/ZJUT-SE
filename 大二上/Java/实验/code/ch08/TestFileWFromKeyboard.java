package cn.edu.zjut.java.ch08;

import java.io.*;

/*从键盘输入一行文字，写入文件TestFileOut.txt中，注意：中文输入会产生乱码问题*/

public class TestFileWFromKeyboard {
	public static void main(String args[]) {
		char c[] = new char[512];
		byte b[] = new byte[512];
		int n, i;
		try {
			String desFile = "TestFileOut2.txt";
			FileWriter wf = new FileWriter(desFile);

			// 利用InputStreamReader正确读取中文
			System.out.print("请输入中文：");
			// System.in是字节流，通过InputStreamReader将其转换为字符流
			InputStreamReader isr = new InputStreamReader(System.in);
			n = isr.read(c, 0, 512);// 一次性读取512个字符，n表示实际读取的字符数
			wf.write(c);

			// 从键盘读入文字并存入字节数组b中
			System.out.print("请输入(中文将出现乱码)：");
			n = System.in.read(b);
			for (i = 0; i < n; i++)
				c[i] = (char) b[i];

			wf.write(c);
			wf.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
