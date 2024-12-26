package com.pattern.factory.abstractFactory.card;

/**
 * 接口实现类 普通卡
 */
public class Ordinary implements Type{
    @Override
    public void issue() {
        System.out.println("发行普通卡");
    }
}