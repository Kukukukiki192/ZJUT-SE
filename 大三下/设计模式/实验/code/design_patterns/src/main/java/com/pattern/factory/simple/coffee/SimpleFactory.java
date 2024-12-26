package com.pattern.factory.simple.coffee;

/**
 * 简单咖啡工厂类,用来生产咖啡 处理创建对象的细节
 */
public class SimpleFactory {
    public static Coffee createCoffee(String type){
        Coffee coffee=null;
        if(type.equals("American")) coffee=new AmericanCoffee();
        else if(type.equals("Latte")) coffee=new LatteCoffee();
        else throw new RuntimeException("点单失败");

        return coffee;
    }
}
