package cn.edu.zjut.java.ch08;

import java.io.File;

//第②步：使用File类的list()和listFiles()进行过滤
public class TestFileSearch {
	public static void main(String args[]) {

	
		String strDir = "./src/cn/edu/zjut/java/ch08";
		//String strDir = "./src/cn/edu/zjut/java/ch08", strExtension = "Test*.java";
		File f = new File(strDir);
		ListFilter ls = new ListFilter("*.java");
		String str[] = f.list(ls);
		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);
	}
	
}
