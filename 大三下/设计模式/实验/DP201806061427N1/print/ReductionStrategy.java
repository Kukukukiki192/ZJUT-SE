package com.pattern.strategy.print;

/**
 * 具体策略类-每台减扣固定的金额
 */
public class ReductionStrategy implements Strategy {
    private double reduction=100d;

    @Override
    public double getPrice(double price) {
        System.out.println("每台减扣固定的金额");
        return price-reduction;
    }
}
