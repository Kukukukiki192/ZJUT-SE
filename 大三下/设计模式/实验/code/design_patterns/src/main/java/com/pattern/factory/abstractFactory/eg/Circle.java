package com.pattern.factory.abstractFactory.eg;

/**
 * 具体形状-圆形
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}