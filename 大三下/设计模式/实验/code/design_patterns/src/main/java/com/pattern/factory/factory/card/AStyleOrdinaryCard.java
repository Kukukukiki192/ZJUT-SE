package com.pattern.factory.factory.card;

public class AStyleOrdinaryCard extends Card {

	public AStyleOrdinaryCard() {
		name = "A Style general level Ordinary Card";
		num++;
	}

	void box() 
	{
		System.out.println("Putting the card into ordinary color box");
	}
}