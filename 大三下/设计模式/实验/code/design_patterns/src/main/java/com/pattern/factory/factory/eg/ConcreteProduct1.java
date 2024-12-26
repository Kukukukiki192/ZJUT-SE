package com.pattern.factory.factory.eg;

/**
 * 具体产品：ProductA
 */
public class ConcreteProduct1 implements Product{
    @Override
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
