package com.pattern.factory.factory.eg;

/**
 * 具体产品：ProductB
 */
public class ConcreteProduct2 implements Product{
    @Override
    public void show() {
        System.out.println("具体产品2显示...");
    }
}
