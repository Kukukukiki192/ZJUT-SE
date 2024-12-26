package cn.edu.zjut.java.ch06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDealCard {

    public static void main(String args[]) {
        int numHands = 4, cardsPerHand = 13;
        //生成一副牌（含52张牌）
        String[] suit = {"♠", "♣", "♥", "♦"};
        String[] rank = {"A","2","3","4","5","6","7",
              "8","9","10","J","Q","K"}; 
        List deck = new ArrayList();
        for (int i = 0; i < suit.length; i++)
            for (int j = 0; j < rank.length; j++)
                deck.add(suit[i]+rank[j]);
        //洗牌: 随机改变元素次序
        Collections.shuffle(deck); 
        for (int i = 0; i < numHands; i++) {
            //生成一手牌,并对牌按花色排序后输出。
            List p = dealCard(deck, cardsPerHand);
            Collections.sort(p);
            System.out.println(p); 
        }   
    } 
    
    public static List dealCard(List deck, int n) {
        int deckSize = deck.size();
        //从deck中截取一个子链表
        List handView = 
                deck.subList(deckSize-n, deckSize);
        //利用该子链表创建一个链表
        List hand = new ArrayList(handView);  
        handView.clear(); //将子链表清空。
        return hand;
    }//dealCard

}

