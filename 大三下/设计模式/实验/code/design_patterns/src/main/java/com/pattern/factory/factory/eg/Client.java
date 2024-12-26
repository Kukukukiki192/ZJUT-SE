package com.pattern.factory.factory.eg;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory=new ConcreteFactory1();
        Product product=factory.createProduct();
        product.show();

        factory=new ConcreteFactory2();
        product=factory.createProduct();
        product.show();
    }
}
