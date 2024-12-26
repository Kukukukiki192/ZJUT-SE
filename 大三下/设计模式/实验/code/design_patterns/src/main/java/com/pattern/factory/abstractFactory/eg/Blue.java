package com.pattern.factory.abstractFactory.eg;

/**
 * 具体颜色-蓝色
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
