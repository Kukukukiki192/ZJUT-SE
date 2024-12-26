package com.pattern.strategy.eg;

/**
 * 环境类
 */
public class Context {
    private Strategy strategy;

//      也可用构造方法指定策略
//    public Context(Strategy strategy) {
//        this.strategy = strategy;
//    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod(){
        strategy.strategyMethod();
    }
}
