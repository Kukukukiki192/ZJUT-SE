package cn.edu.zjut.java.ch08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.edu.zjut.vis.file.VFileHelper;

public class FileIn {
	  public static void main(String args[]) {
	      try {
	         String strFile = "Poem1.txt";
	         //打开文件
	         FileInputStream rf = new FileInputStream(strFile);
	         int b;
	         while ((b = rf.read()) != -1)
	            //用read()方法逐个字节读取
	            System.out.print((char) b); // 转换成char并显示
	         rf.close();
	     } catch (IOException ie) {
	         System.out.println(ie);
	     } catch (Exception e) {
	         System.out.println(e);
	     }
	   }
}
