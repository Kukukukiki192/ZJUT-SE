package com.pattern.observer.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知者
 */
public class Notifier {

    //ArrayList存放多种股票报告
    private List<Stock> stocks = new ArrayList<Stock>();

    //股票价格变动状态
    private float price;

    public float getPrice() {
        return price;
    }

    //更新股票价格状态
    public void setPrice(float price) {
        this.price = price;
        notifyAllStocks();
    }

    //增加股票报告
    public void add(Stock stock) {
        if(!stocks.contains(stock))
            stocks.add(stock);
    }

    //删除股票报告
    public void remove(Stock stock) {
        if(stocks.contains(stock))
            stocks.remove(stock);
    }

    public void notifyAllStocks(){
        for (Stock stock : stocks) {
            stock.update(price);
        }
    }
}
