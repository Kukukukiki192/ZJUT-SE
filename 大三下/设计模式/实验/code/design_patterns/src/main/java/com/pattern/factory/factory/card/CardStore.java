package com.pattern.factory.factory.card;

/**
 * 抽象工厂类 会员卡制作商
 */
public abstract class CardStore {

   abstract Card createCard(String item);

   public Card orderCard(String type) {
	   Card card = createCard(type);
	   System.out.println("--- Making a " + card.getName() + " ---");
	   card.prepare();
	   card.box();
	   return card;
   }
}