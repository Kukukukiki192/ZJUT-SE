package com.pattern.factory.simple.coffee;

public class CoffeeStore {
    public Coffee oderCoffee(String type){
        //原始创建对象方式
//        Coffee coffee=null;
//        if(type.equals("American")) coffee=new AmericanCoffee();
//        else if(type.equals("Latte")) coffee=new LatteCoffee();
//        else throw new RuntimeException("点单失败");

//        //创建咖啡对象交给工厂
//        SimpleFactory factory=new SimpleFactory();
//        Coffee coffee = factory.createCoffee(type);//解除了咖啡类(抽象类)和具体产品(实现类)的依赖
        Coffee coffee=SimpleFactory.createCoffee(type);//用static可直接通过类名调用类方法,无需创建类对象

        //调用对象方法
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
