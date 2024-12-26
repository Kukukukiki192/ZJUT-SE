package com.pattern.observer.stock;

/**
 * 具体观察者 股票当前价格
 */
public class StockNormal extends Stock {
    
    public StockNormal(Notifier notifier){
        this.notifier=notifier;   //维持一个指向通知者的引用
        this.notifier.add(this);
    }

    @Override
    public void update(float price) {
        System.out.println("股票当前价格:");
        System.out.println("¥"+price);
    }
}
