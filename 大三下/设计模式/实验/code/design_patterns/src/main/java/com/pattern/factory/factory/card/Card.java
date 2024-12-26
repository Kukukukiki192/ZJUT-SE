package com.pattern.factory.factory.card;

/**
 * 抽象产品类 会员卡
 */
public abstract class Card {

	String name;
	static int num=0;

	void prepare() {
		System.out.println("Preparing " + name);
		System.out.println("Register customer...");
		System.out.println("Deliver cards...");
	}

	void box() {
		System.out.println("Place card in official CardStore box");
	}

	public String getName() 
	{
		return name;
	}

	public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append("card number is " + num + "\n");
		return display.toString();
	}

}