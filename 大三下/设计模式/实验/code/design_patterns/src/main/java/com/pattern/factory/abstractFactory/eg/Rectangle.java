package com.pattern.factory.abstractFactory.eg;

/**
 * 具体形状-三角形
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}