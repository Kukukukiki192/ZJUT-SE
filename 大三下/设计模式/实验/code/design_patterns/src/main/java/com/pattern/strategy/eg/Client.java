package com.pattern.strategy.eg;

public class Client {
    public static void main(String[] args) {
        Context c=new Context();//持有抽象策略的引用来调用
        Strategy s=new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("-----------------");
        s=new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }
}
