package com.pattern.factory.abstractFactory.card;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        //获取卡类型工厂
        AbstractFactory typeFactory = FactoryProducer.getFactory("type");
        //获取卡风格工厂
        AbstractFactory styleFactory = FactoryProducer.getFactory("style");

        //获取金卡类型的对象
        Type typeA = typeFactory.getType("gold");
        //获取银卡类型的对象
        Type typeB = typeFactory.getType("silver");
        //获取普通卡类型的对象
        Type typeC = typeFactory.getType("ordinary");

        //获取A风格的对象
        Style styleA = styleFactory.getStyle("A");
        //获取B风格的对象
        Style styleB = styleFactory.getStyle("B");


        //发行金卡
        typeA.issue();
        //提供A风格发卡服务
        styleA.service();

        //发行银卡
        typeB.issue();
        //提供B风格发卡服务
        styleB.service();

        //发行普通卡
        typeC.issue();
        //提供A风格发卡服务
        styleA.service();
    }
}
