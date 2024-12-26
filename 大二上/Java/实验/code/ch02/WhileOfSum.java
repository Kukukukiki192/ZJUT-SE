package cn.edu.zjut.java.ch02;

import java.math.BigDecimal;

public class WhileOfSum {
	public static void main(String[] args) {
//		int i, sum;
//		sum = 0; // 累加器清0
//		i = 1; // i的初始值为1
//		while (i <= 10) {
//			sum += i;
//			i++;
//		}
//		System.out.println("sum=" + sum);
	
		
		double d1 = 0.5;
		d1 = 0.1 + d1;
		d1 = 0.1 + d1;
		d1 = 0.1 + d1;
		System.out.println(d1);
		
		
		
		for (double x = 0.1; x != 1.0; x += 0.1) {
			System.out.println(x + ";");
		}
		
		



		
		
		BigDecimal x = new BigDecimal("0.1"); 
		for (; !x.equals(new BigDecimal("1.0")); x = x.add(new BigDecimal("0.1"))) {
			System.out.println(x + ";");
		}
		
		
	}
}
