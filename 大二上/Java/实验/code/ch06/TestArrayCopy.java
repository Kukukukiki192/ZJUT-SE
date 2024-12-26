package cn.edu.zjut.java.ch06;

public class TestArrayCopy {

	public static void main(String args[]){
	int smallPrimes[]= {1, 2, 3, 4, 5, 6};
	int lucyNumbers[]= {1001, 1002, 1003, 1004, 1005, 1006, 1007};
	System.arraycopy(smallPrimes, 1, lucyNumbers, 2, 5);
	for(int i=0; i<lucyNumbers.length; i++)
		System.out.println(i+": "+lucyNumbers[i]);

	Runtime r = Runtime.getRuntime();
	System.out.println(r.freeMemory()/1024);
	System.out.println(r.totalMemory()/1024);

	
	}
	
	
}
