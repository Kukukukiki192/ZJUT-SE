package cn.edu.zjut.java.ch07;

import java.io.IOException;

public class TestTry {

	   public static void main(String[] args) {
		      try {
		         int b = 12, c;
		         c = b / 1;
		         System.out.println("c=" + c);
		         c = b / 0; //发生异常则跳过该行后语句，执行catch或finally块
		         System.out.println("c=" + c);
		      } catch (ArithmeticException ae) {
		         //catch 到一个异常匹配，则不再找其他异常了
		         System.out.println("捕获了一个零除异常");
		//         System.exit(0);
		      } catch (Exception ex) {
		         System.out.println("捕获了一个未知类型的异常");
		      } finally {
		         //1. finally语句块无论是否发生异常都要执行，除非遇到“System.exit();”   
		         //2. finally语句块一般包括：文件关闭、关闭数据库连接、关闭网络连接等
		         System.out.println("异常处理结束");
		      } //try-catch-finally
		   } //main
}
