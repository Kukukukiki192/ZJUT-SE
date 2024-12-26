package com.pattern.factory.abstractFactory.card;

/**
 * 具体工厂类 会员卡类型工厂
 */
public class TypeFactory extends AbstractFactory{

    final class Const {
        static final String TYPE_A = "gold";
        static final String TYPE_B = "silver";
        static final String TYPE_C = "ordinary";
    }

    @Override
    public Type getType(String type) {
        switch (type) {
            case Const.TYPE_A:
                return new Gold();
            case Const.TYPE_B:
                return new Silver();
            case Const.TYPE_C:
                return new Ordinary();
        }
        return null;
    }

    @Override
    public Style getStyle(String style) {
        return null;
    }
}
