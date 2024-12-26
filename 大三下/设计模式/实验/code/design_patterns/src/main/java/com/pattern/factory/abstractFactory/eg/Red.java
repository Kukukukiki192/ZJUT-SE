package com.pattern.factory.abstractFactory.eg;

/**
 * 具体颜色-红色
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}