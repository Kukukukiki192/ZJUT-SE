package cn.edu.zjut.java.ch07;

import java.io.IOException;

public class TestTry {

	   public static void main(String[] args) {
		      try {
		         int b = 12, c;
		         c = b / 1;
		         System.out.println("c=" + c);
		         c = b / 0; //�����쳣���������к���䣬ִ��catch��finally��
		         System.out.println("c=" + c);
		      } catch (ArithmeticException ae) {
		         //catch ��һ���쳣ƥ�䣬�����������쳣��
		         System.out.println("������һ������쳣");
		//         System.exit(0);
		      } catch (Exception ex) {
		         System.out.println("������һ��δ֪���͵��쳣");
		      } finally {
		         //1. finally���������Ƿ����쳣��Ҫִ�У�����������System.exit();��   
		         //2. finally����һ��������ļ��رա��ر����ݿ����ӡ��ر��������ӵ�
		         System.out.println("�쳣�������");
		      } //try-catch-finally
		   } //main
}
