package cn.edu.zjut.java.ch07;

public class TestExcepMethod {

	public static void main(String[] args) {
		
	      try {
	          throw new Exception("��Ϊ�׳��Ĳ����쳣��");
	       } catch (Exception e) {
	          System.out.println("�쳣�Ѳ���");
	          System.out.println("e.getMessage(): " 
	                + e.getMessage());
	          System.out.println("e.toString(): " + e);
	          System.out.println("e.printStackTrace():");
	          e.printStackTrace();


	}
	}

}
