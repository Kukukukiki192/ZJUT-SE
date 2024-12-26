package com.pattern.strategy.crab;

import javax.swing.*;

/**
 * 具体策略类：清蒸大闸蟹
 */
public class SteamedCrabs extends JLabel implements CrabCooking {
    private static final long serialVersionUID = 1L;

    @Override
    public void CookingMethod() {
        this.setIcon(new ImageIcon("src/main/java/com/pattern/strategy/crab/SteamedCrabs.jpg"));//src/main/java/com/pattern/strategy/crab/SteamedCrabs.jpg
        this.setHorizontalAlignment(CENTER);
    }
}
