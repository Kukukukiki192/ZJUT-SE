package com.pattern.factory.factory.card;

/**
 * 具体工厂类 会员卡制作商A
 */
public class ACardStore extends CardStore {
	Card createCard(String item) {
        	if (item.equals("gold")) {
            		return new AStyleGoldCard();
        	} else if (item.equals("silver")) {
        	    	return new AStyleSilverCard();
        	} else if (item.equals("ordinary")) {
        	    	return new AStyleOrdinaryCard();
        	} else return null;
	}
}