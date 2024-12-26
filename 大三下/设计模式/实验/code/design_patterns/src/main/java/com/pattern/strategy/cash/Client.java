package com.pattern.strategy.cash;

public class Client {
    public static void main(String[] args) {
        CashContext c=new CashContext("正常收费");
        System.out.println(c.getResult(1000));
        c=new CashContext("打8折");
        System.out.println(c.getResult(1000));
        c=new CashContext("满300返100");
        System.out.println(c.getResult(1000));
    }
}
