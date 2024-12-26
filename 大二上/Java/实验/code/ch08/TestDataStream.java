package cn.edu.zjut.java.ch08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {

	public static void main(String args[]) {
	      try {
	         //为temp.dat创建输出流
	         String datFile = "temp.dat";
	         DataOutputStream output = 
	             new DataOutputStream(new FileOutputStream(datFile));
	         //输出学生成绩
	         output.writeUTF("张三"); output.writeDouble(59.5);
	         output.writeUTF("李四"); output.writeDouble(60.5);
	         output.writeUTF("王五"); output.writeDouble(89);
//	         output.writeInt(123456);
//	         output.close();
	         //读取并打印学生成绩
	         DataInputStream input = 
	            new DataInputStream(new FileInputStream(datFile));
	         System.out.printf("%s: %.2f\n", input.readUTF(), input.readDouble());
	         System.out.printf("%s: %.2f\n", input.readUTF(), input.readDouble());
	         System.out.printf("%s: %.2f\n", input.readUTF(), input.readDouble());
	         input.close();
	         
	         
	         
	         
	      } catch (IOException ie) {
	         System.out.println(ie.toString());
	      } 
	   }

}
