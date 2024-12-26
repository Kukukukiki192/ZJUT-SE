package com.pattern.strategy.crab;

/**
 * 环境类
 */
public class Kitchen {
    private CrabCooking strategy;

    public CrabCooking getStrategy() {
        return strategy;
    }

    public void setStrategy(CrabCooking strategy) {
        this.strategy = strategy;
    }

    public void CookingMethod(){
        strategy.CookingMethod();
    }
}
