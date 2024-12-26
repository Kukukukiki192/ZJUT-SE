package com.pattern.observer.stock;

import java.util.Vector;

/**
 * 具体观察者 股票价格的统计分析报告(最低价、最高价、均价)
 */
public class StockAnalysis extends Stock {

    //存储股票数量
    private int count;
    //存储股票最高价、最低价、均价、总价
    private float max,min,avg,sum;
    //存储股票价格
    private Vector<Float> v=new Vector<Float>();
    
    public StockAnalysis(Notifier notifier){
        count=0;
        sum=0;
        this.notifier=notifier;   //维持一个指向通知者的引用
        this.notifier.add(this);
    }

    @Override
    public void update(float price) {
        v.add(price);
        if(v.size()==1){
            max=price;
            min=price;
        } else {
            if(price>max) max=price;
            if(price<min) min=price;
        }
        ++count;
        sum+=price;
        avg=sum/count;

        System.out.println("股票分析报告:");
        System.out.println("最高价 ¥" + max);
        System.out.println("最低价 ¥" + min);
        System.out.println("平均价 ¥" + avg);
    }
}
