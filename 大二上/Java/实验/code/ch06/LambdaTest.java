package cn.edu.zjut.java.ch06;

import java.util.ArrayList;

import cn.edu.zjut.java.ch02.WhileOfSum;
 
/**
 * 这里的接口里只有一个方法的时候，为函数式接口
 * 编译器也会把该接口当做函数式接口
 * @author Guodao
 *
 */
interface MyLambdaInterface{  
	void doSomeShit(String s);   //传统的Java 7必须要求你定义一个“污染环境”的接口实现MyInterfaceImpl，而相较之下Java 8的Lambda, 就显得干净很多。
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
