package cn.edu.zjut.java.ch08;

import java.io.*;


public class TestFileLIST {
	public static void main(String args[]) throws IOException {
		File files = new File("."); // "."表示当前目录(与工程 所在的同一个目录)
		listPath(files);
	}

	public static void listPath(File f) throws IOException {
		String file_list[] = f.list();
		for (int i = 0; i < file_list.length; i++) {
			File cf = new File(f.getPath(), file_list[i]);
			if (cf.isDirectory()) {// 判断是否为子目录
				listPath(cf);// 列举该子目录下的文件
			}
			if (cf.isFile()) {// 判断是否为文件
				try {
					// 输出文件大小
					System.out.println(cf.getCanonicalPath() + ":"
							+ cf.length());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
