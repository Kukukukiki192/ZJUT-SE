package com.pattern.factory.factory.card;

/**
 * 具体工厂类 会员卡制作商A
 */
public class BCardStore extends CardStore {
	Card createCard(String item) {
        	if (item.equals("gold")) {
            		return new BStyleGoldCard();
        	} else if (item.equals("silver")) {
        	    	return new BStyleSilverCard();
        	} else if (item.equals("ordinary")) {
        	    	return new BStyleOrdinaryCard();
        	} else return null;
	}
}