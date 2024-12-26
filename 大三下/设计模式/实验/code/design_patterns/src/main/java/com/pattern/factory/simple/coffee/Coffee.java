package com.pattern.factory.simple.coffee;

/**
 * 咖啡类
 */
public abstract class Coffee {
    //获取咖啡种类
    public abstract String getType();

    //加料
    public void addMilk(){
        System.out.println("加奶");
    }
    public void addSugar(){
        System.out.println("加糖");
    }
}
