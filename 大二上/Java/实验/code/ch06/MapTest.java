package cn.edu.zjut.java.ch06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import cn.edu.zjut.java.ch03.Student;

public class MapTest {
	public static void main(String[] args) {
		Map map = new HashMap<String, String>();
		map.put("y", "ccc");
		map.put("x", "aaa");
		map.put("z", "bbb");
		map.put("s", "ddd");
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()) {
		Object key = iter.next();
		System.out.println("map key " + key.toString() + " value=" + map.get(key));  
		}
		TreeMap tab = new TreeMap();
		tab.put("a", "aaa");   
		tab.put("c", "ccc");
		tab.put("d", "ddd");
		tab.put("b", "bbb");
		Iterator iter2 = tab.keySet().iterator();
		while(iter2.hasNext()) {
		Object key = iter2.next();
		System.out.println("tab key " + key.toString() + " value=" + tab.get(key)); 
		}
		
		
		//无equals
		Set<Student> set = new HashSet<Student>();
		Student s1 = new Student(11, "aa");
		Student s2 = new Student(11, "aa");
		set.add(s1);
		System.out.println(set.contains(s2));
		
		String[] strings = {"A", "B", "C", "D"};

		for (Object str : strings ){//开始遍历
			System.out.println(str);//依次输出
		}
	} 

}
