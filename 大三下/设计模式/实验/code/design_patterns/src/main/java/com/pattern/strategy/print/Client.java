package com.pattern.strategy.print;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        Printer c=new Printer();//持有抽象策略的引用来调用
        Strategy s;
        double price=1000d;
        s=new NoDiscountStrategy();
        c.setStrategy(s);
        System.out.println(c.getPrice(price));
        System.out.println("-----------------");
        s=new ReductionStrategy();
        c.setStrategy(s);
        System.out.println(c.getPrice(price));
        System.out.println("-----------------");
        s=new DiscountStrategy();
        c.setStrategy(s);
        System.out.println(c.getPrice(price));
    }
}
