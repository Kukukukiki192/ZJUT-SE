package com.pattern.strategy.print;

/**
 * 具体策略类-打折5%
 */
public class DiscountStrategy implements Strategy {
    private double rate=0.05d;

    @Override
    public double getPrice(double price) {
        System.out.println("5%折扣优惠");
        return price * (1-rate);
    }
}