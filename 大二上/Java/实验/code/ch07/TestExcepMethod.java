package cn.edu.zjut.java.ch07;

public class TestExcepMethod {

	public static void main(String[] args) {
		
	      try {
	          throw new Exception("人为抛出的测试异常！");
	       } catch (Exception e) {
	          System.out.println("异常已捕获。");
	          System.out.println("e.getMessage(): " 
	                + e.getMessage());
	          System.out.println("e.toString(): " + e);
	          System.out.println("e.printStackTrace():");
	          e.printStackTrace();


	}
	}

}
