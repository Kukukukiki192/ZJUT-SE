package cn.edu.zjut.java.ch09;

import java.awt.Frame;
import java.awt.Color;

public class Eg01TestAWT extends Frame{
	public Eg01TestAWT (String str){ 
		super(str); 
		}
	
		public static void main(String args[ ]){ 
			Eg01TestAWT fr = new Eg01TestAWT ("Hello AWT Frame!"); 
		//����Frame�Ĵ�С��ȱʡΪ��0��0��
		fr.setSize(400,300); 
		//����Frame�ı���Ϊ��ɫ
		fr.setBackground(Color.red);
		//����FrameΪ�ɼ���ȱʡΪ���ɼ�
		fr.setVisible(true);
		}

}
