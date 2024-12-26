package com.pattern.strategy.crab;

import javax.swing.*;

/**
 * 具体策略类：红烧大闸蟹
 */
public class BraisedCrabs  extends JLabel implements CrabCooking {
    private static final long serialVersionUID = 1L;

    @Override
    public void CookingMethod() {
        this.setIcon(new ImageIcon("src/main/java/com/pattern/strategy/crab/BraisedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }
}