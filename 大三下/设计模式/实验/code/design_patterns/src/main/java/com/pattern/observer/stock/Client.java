package com.pattern.observer.stock;

import java.util.Random;

/**
 * 客户端
 * 模拟股票价格的变动
 * 股票的当前价格；股票价格的统计分析报告（最低价、最高价、均价）；股票价格趋势预测
 */
public class Client {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();
        new StockNormal(notifier);
        new StockAnalysis(notifier);
        new StockTrend(notifier);
//        Stock stockNormal = new StockNormal(notifier);
//        Stock stockAnalysis = new StockAnalysis(notifier);
//        Stock stockTrend = new StockTrend(notifier);

        final Random random = new Random();
        float price;
        for(int i=0;i<10;i++){
            price=random.nextFloat()*100;//[0.0,100.0)

            //股票价格变动 通知所有股票报告并更新
            System.out.println("估价第"+(i+1)+"次变动-----------------------");
            notifier.setPrice(price);
        }

    }
}
