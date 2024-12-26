package cn.edu.zjut.java.ch05;

public class PassArray2 {
	static void initializeArray(int[] arrays, int n) {
		arrays = new int[n];
		for (int i = 0; i < n; ++i)
			arrays[i] = i;

//		for (int i = 0; i < arrays.length; i++)
//			System.out.println(arrays[i] + " ");
		
	}

	public static void main(String[] args) {
		int[] hold = null;
		initializeArray(hold, 9);
		for (int i = 0; i < hold.length; i++)
			System.out.println(hold[i] + " ");
	}
}
