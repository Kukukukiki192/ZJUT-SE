package cn.edu.zjut.java.ch03;

import java.util.*; 

public class PassTest{
	float ptValue;	
	//���������ǻ�������
	public void changeInt(int value){
		value = 55 ; 
		
		
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, String> map;
		
	}	
	
	//���������������ͣ����ҷ����иı��˲�����ָ�����ĳ�Ա����ֵ
//	public void changeObjValue( PassTest ref){
//		//ref.ptValue = 99.0f;
//		ref = new PassTest();
//		ref.ptValue = 222;		
//	}

	//���������������ͣ����ҷ����иı������ֵ
	public void changeStr(String value){
		//value = new String("different"); 
		value = value.replace("Hello", "Hola");
	}	
	
	
	public static void main(String[] args) {
		String str;
		int val;	
        //����PassTest�Ķ���			
		PassTest pt= new PassTest( ); 
		
//	�����������Ͳ����Ĵ���		
        str = new String("Hello");
		pt.changeStr(str);
		System.out.println("Str value is: " +str);	
		
		
		
		
//		//�����������Ͳ����Ĵ���
//		pt.ptValue = 101.0f ;
//		pt.changeObjValue(pt);
//		System.out.println("Pt value is: " +pt.ptValue);
		
		
		
//        //���Ի������Ͳ����Ĵ���		
//        val = 11;
//		pt.changeInt(val);
//		System.out.println("Int value is: " +val);
	

		
       // Student.printMotto();

		

	}
	



}
