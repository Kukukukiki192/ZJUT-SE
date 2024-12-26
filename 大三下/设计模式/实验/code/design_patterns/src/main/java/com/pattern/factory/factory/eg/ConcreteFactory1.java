package com.pattern.factory.factory.eg;

/**
 * 具体工厂1：实现了厂品的生成方法
 */
public class ConcreteFactory1 implements  AbstractFactory{
    @Override
    public Product createProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
