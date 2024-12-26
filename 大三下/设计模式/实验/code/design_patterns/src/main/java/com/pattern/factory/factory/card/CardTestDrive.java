package com.pattern.factory.factory.card;

public class CardTestDrive {
	public static void main(String[] args) {
		CardStore aStore = new ACardStore();
		CardStore bStore = new BCardStore();
		
		Card card = aStore.orderCard("gold");
		System.out.println("Ethan got a " + card.getName() + "\n");
		System.out.println(card);
		card = bStore.orderCard("gold");
		System.out.println("Joel got a " + card.getName() + "\n");
		System.out.println(card);
		
		card = aStore.orderCard("silver");
		System.out.println("Ethan got a " + card.getName() + "\n");
		System.out.println(card);
		card = bStore.orderCard("silver");
		System.out.println("Joel got a " + card.getName() + "\n");
		System.out.println(card);
		
		card = aStore.orderCard("ordinary");
		System.out.println("Ethan got a " + card.getName() + "\n");
		System.out.println(card);
		card = bStore.orderCard("ordinary");
		System.out.println("Joel got a " + card.getName() + "\n");
		System.out.println(card);
	}
}