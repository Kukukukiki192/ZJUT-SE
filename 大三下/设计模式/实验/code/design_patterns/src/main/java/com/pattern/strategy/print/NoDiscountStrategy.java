package com.pattern.strategy.print;

/**
 * 具体策略类-不打折
 */
public class NoDiscountStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("无折扣优惠");
        return price;
    }
}