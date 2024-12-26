package com.pattern.factory.abstractFactory.card;

/**
 * 接口实现类 B风格
 */
public class BStyle implements Style{
    @Override
    public void service() {
        System.out.println("提供B风格服务");
    }
}