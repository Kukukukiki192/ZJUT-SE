package cn.edu.zjut.java.ch05;

import cn.edu.zjut.java.exp03.oop.MovableMachine;
import cn.edu.zjut.java.exp03.oop.VehicleFactory;

public class ArrayTest {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4 }; 	//ע��û��new
		//int a[] = new int[] { 1, 2, 3, 4 }; //û�����鳤�� 
		//int a[] = new int[4] { 1, 2, 3, 4 }; 
		char[] c = { 'A', 'B', 'C', 'D' };
		String[] str = { "How", "are", "you" };
		
		//MovableMachine ns = VehicleFactory.getVehicle("xxx");
		//.move();
		
	    char cArray[][] = { {'A', 'B'}, {'C'}, {'D', 'E', 'F'} }; 
	    System.out.println(cArray.getClass().getTypeName() + 
	        ":" + cArray[0].length);
	    
	    String s = "ABCDEF";
	    System.out.println(s.substring(1,3));
		
	}

}
