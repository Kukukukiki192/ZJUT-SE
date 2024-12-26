package com.pattern.template.soyaMilk;

/**
 * 具体子类 纯豆浆
 */
public class PureSoyaMilk extends SoyaMilk{
    @Override
    void add() {
        //空实现 纯豆浆不添加配料
    }

    @Override
    boolean isAdd() {
        return false;
    }
}
