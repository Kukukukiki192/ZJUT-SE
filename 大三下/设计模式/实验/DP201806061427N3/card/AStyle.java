package com.pattern.factory.abstractFactory.card;

/**
 * 接口实现类 A风格
 */
public class AStyle implements Style{
    @Override
    public void service() {
        System.out.println("提供A风格服务");
    }
}
