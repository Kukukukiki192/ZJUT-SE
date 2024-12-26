package com.pattern.factory.abstractFactory.eg;

/**
 * 具体形状-方形
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
