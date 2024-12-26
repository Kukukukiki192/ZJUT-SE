package cn.edu.zjut.java.ch08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {

	public static void main(String args[]) {
	      try {
	         //Ϊtemp.dat���������
	         String datFile = "temp.dat";
	         DataOutputStream output = 
	             new DataOutputStream(new FileOutputStream(datFile));
	         //���ѧ���ɼ�
	         output.writeUTF("����"); output.writeDouble(59.5);
	         output.writeUTF("����"); output.writeDouble(60.5);
	         output.writeUTF("����"); output.writeDouble(89);
//	         output.writeInt(123456);
//	         output.close();
	         //��ȡ����ӡѧ���ɼ�
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
