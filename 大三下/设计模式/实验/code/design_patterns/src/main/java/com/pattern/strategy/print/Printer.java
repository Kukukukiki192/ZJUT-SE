package com.pattern.strategy.print;

/**
 * 环境类
 */
public class Printer {
    private Strategy strategy;

//      也可用构造方法指定策略
//    public Context(Strategy strategy) {
//        this.strategy = strategy;
//    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price){
        return strategy.getPrice(price);
    }
}
