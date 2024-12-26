package cn.edu.zjut.java.ch06;

import java.util.ArrayList;

import cn.edu.zjut.java.ch02.WhileOfSum;
 
/**
 * ����Ľӿ���ֻ��һ��������ʱ��Ϊ����ʽ�ӿ�
 * ������Ҳ��Ѹýӿڵ�������ʽ�ӿ�
 * @author Guodao
 *
 */
interface MyLambdaInterface{  
	void doSomeShit(String s);   //��ͳ��Java 7����Ҫ���㶨��һ������Ⱦ�������Ľӿ�ʵ��MyInterfaceImpl�������֮��Java 8��Lambda, ���Եøɾ��ܶࡣ
}

public class LambdaTest {

	
	public static void useFunction(MyLambdaInterface f, String s){
		f.doSomeShit(s);
	}
	
	
	public static void main(String[] args) { 


		foreachTest();
		
		
		MyLambdaInterface lam = (s) -> System.out.println(s);
		lam.doSomeShit("");
		

		useFunction(lam, "hello");
		useFunction((s) -> System.out.println(s + " world!"), "hello");
		
	}
	
	public static void foreachTest(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.forEach(obj -> System.out.println(obj));
		list.forEach(obj -> {
			obj ++;
			System.out.println(obj);
			}
		);
	}
	

}
