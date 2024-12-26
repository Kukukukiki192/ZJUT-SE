package cn.edu.zjut.java.ch09;

import java.awt.Frame;
import java.awt.Color;

public class Eg01TestAWT extends Frame{
	public Eg01TestAWT (String str){ 
		super(str); 
		}
	
		public static void main(String args[ ]){ 
			Eg01TestAWT fr = new Eg01TestAWT ("Hello AWT Frame!"); 
		//设置Frame的大小，缺省为（0，0）
		fr.setSize(400,300); 
		//设置Frame的背景为红色
		fr.setBackground(Color.red);
		//设置Frame为可见，缺省为不可见
		fr.setVisible(true);
		}

}
