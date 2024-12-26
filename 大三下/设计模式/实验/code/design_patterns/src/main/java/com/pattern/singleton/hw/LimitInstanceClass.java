package com.pattern.singleton.hw;

import java.io.*;
import java.time.LocalTime;

public class LimitInstanceClass {
	static int i=5;
	int id=0;//对象编号
	boolean isBusy; //如果该变量的值为true，表示该对象正在被使用，否则该对象空闲
	String accessMessage=new String();
	
	static {
		try {
			FileInputStream f=new FileInputStream("D:\\CodeProjects\\IdeaProjects\\design_patterns\\src\\main\\java\\com\\pattern\\singleton\\hw\\InstanceLimit.cfg");
			i=f.read()-48;
			System.out.println("能产生"+i+"个对象");
			f.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	//饿汉式多例 类加载时就初始化
	private static LimitInstanceClass instance[]=new LimitInstanceClass[i];
	static {
		for(int m=0;m<i;m++) {
			instance[m]=new LimitInstanceClass();
		}
	}

	//让构造函数为 private，这样该类就不会被实例化
	private LimitInstanceClass() {
		isBusy=false;
	}
	//获取空闲对象
	public static LimitInstanceClass getInstance() {
		int x;
		for(x=0;x<i-1;x++) {
			if(instance[x].isBusy==false) {
				instance[x]=new LimitInstanceClass();
				instance[x].isBusy=true;
				break;
			}
		}
		return instance[x];
	}

	//追加
	public void writeAccessMessage(String message) {
		accessMessage=message;
	}

	//输出
	public String printAccessMessage(){
		System.out.println(LocalTime.now().withNano(0) + " " + accessMessage);
		return accessMessage;
	}

	//释放一个对象
	public void release() {
		isBusy=false;
	}
}