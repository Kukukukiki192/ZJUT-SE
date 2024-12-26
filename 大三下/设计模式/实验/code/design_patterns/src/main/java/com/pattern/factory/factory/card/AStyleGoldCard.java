package com.pattern.factory.factory.card;

public class AStyleGoldCard extends Card {
	public AStyleGoldCard() {
		name = "A Style high level Gold Card";
		num++;
	}
	void box() 
	{
		System.out.println("Putting the card into gold color box");
	}
}