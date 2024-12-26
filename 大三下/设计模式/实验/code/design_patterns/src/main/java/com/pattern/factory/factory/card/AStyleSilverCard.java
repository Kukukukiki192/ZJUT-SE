package com.pattern.factory.factory.card;

public class AStyleSilverCard extends Card {

	public AStyleSilverCard() {
		name = "A Style middle level Silver Card";
		num++;
	}

	void box() 
	{
		System.out.println("Putting the card into silver color box");
	}
}