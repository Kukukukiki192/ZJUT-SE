package com.pattern.factory.abstractFactory.eg;

/**
 * 具体颜色-绿色
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}