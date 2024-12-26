package com.pattern.factory.abstractFactory.card;

/**
 * 具体工厂类 会员卡风格工厂
 */
public class StyleFactory extends AbstractFactory{

    final class Const {
        static final String Style_A = "A";
        static final String Style_B = "B";
    }

    @Override
    public Type getType(String type) {
        return null;
    }

    @Override
    public Style getStyle(String style) {
        switch (style) {
            case Const.Style_A:
                return new AStyle();
            case Const.Style_B:
                return new BStyle();
        }
        return null;
    }
}
