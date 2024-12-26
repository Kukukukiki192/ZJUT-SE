package cn.edu.zjut.java.ch06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListPerformanceTest {

	
	
	public static void listMapComparison(){
		
		int times = 20000;
		
		ArrayList list = new ArrayList<>();
		Map<Integer, Integer> Map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < 100000; i ++)
			list.add(i);  //0, 1, 2 , 3 
		for(int i = 0; i < 100000; i ++)
			Map.put(i, i);
		
		
		long t1 = System.currentTimeMillis();
		int a = 1;
		for(int i = 0; i < times; i ++){
			if(list.contains(95555)){
				a = 0;
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1 + "ms with list"); 
		
		t1 = System.currentTimeMillis();
		a = 1;
		for(int i = 0; i < times; i ++){
			if(Map.containsKey(95555)){
				a = 0;
			}
		}
		t2 = System.currentTimeMillis();   
		System.out.println(t2-t1 + "ms with map");	 
	}
	
	
	public static void listAddDynamically(){

		int initSize = 10000000;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < initSize; i++){
			list.add(123);
			map.put(i, i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1 + "ms with empty "); 
		
		ArrayList<Integer> list2 = new ArrayList<Integer>(initSize);
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(initSize);
		t1 = System.currentTimeMillis();
		for(int i = 0; i < initSize; i++){
			list2.add(123);	
			map2.put(i, i);	
		}
		
		t2 = System.currentTimeMillis();
		System.out.println(t2-t1 + "ms with init "); 
		
	}
	
	public static void main(String[] args) {
		
		
		listAddDynamically();
		//listMapComparison();

	}

}
