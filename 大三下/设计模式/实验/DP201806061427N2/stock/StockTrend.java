package com.pattern.observer.stock;

import java.util.Vector;

/**
 * 具体观察者 股票价格趋势预测
 */
public class StockTrend extends Stock{

    //存储股票数量
    private int count;
    //存储股票均价
    private double avg;
    //存储股票价格
    private Vector<Float> v=new Vector<Float>();

    public StockTrend(Notifier notifier){
        count=0;
        this.notifier=notifier;   //维持一个指向通知者的引用
        this.notifier.add(this);
    }

    //采用近三天均价预测
    @Override
    public void update(float price) {
        v.add(price);
        int n=v.size();
        if(n==1){
            avg=price;
        } else if(n==2) {
            avg=(v.get(0)+v.get(1))/2;
        } else {
            avg=(v.get(n-1)+v.get(n-2)+v.get(n-3))/3;
        }

        System.out.println("股票价格趋势预测:");
        System.out.println("¥"+avg);
    }
}
