package cn.edu.zjut.java.ch03;

import java.util.*; 

public class PassTest{
	float ptValue;	
	//参数类型是基本类型
	public void changeInt(int value){
		value = 55 ; 
		
		
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, String> map;
		
	}	
	
	//参数类型是引用型，并且方法中改变了参数所指向对象的成员变量值
//	public void changeObjValue( PassTest ref){
//		//ref.ptValue = 99.0f;
//		ref = new PassTest();
//		ref.ptValue = 222;		
//	}

	//参数类型是引用型，并且方法中改变参数的值
	public void changeStr(String value){
		//value = new String("different"); 
		value = value.replace("Hello", "Hola");
	}	
	
	
	public static void main(String[] args) {
		String str;
		int val;	
        //创建PassTest的对象			
		PassTest pt= new PassTest( ); 
		
//	测试引用类型参数的传递		
        str = new String("Hello");
		pt.changeStr(str);
		System.out.println("Str value is: " +str);	
		
		
		
		
//		//测试引用类型参数的传递
//		pt.ptValue = 101.0f ;
//		pt.changeObjValue(pt);
//		System.out.println("Pt value is: " +pt.ptValue);
		
		
		
//        //测试基本类型参数的传递		
//        val = 11;
//		pt.changeInt(val);
//		System.out.println("Int value is: " +val);
	

		
       // Student.printMotto();

		

	}
	



}
