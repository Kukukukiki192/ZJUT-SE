package com.pattern.template.soyaMilk;

/**
 * 抽象类 豆浆
 */
public abstract class SoyaMilk {

    //模板方法 final-防止子类覆盖
    final void make(){
        select();
        if(isAdd())
            add();
        soak();
        beat();
    }

    //1.选材料
    void select(){
        System.out.println("1.选择新鲜的黄豆");
    }

    //2.添加不同配料 抽象方法,子类具体实现
    abstract void add();

    //3.浸泡
    void soak(){
        System.out.println("3.黄豆和配料开始浸泡,需要3h");
    }

    //4.打碎
    void beat(){
        System.out.println("4.黄豆和配料放入豆浆机打碎");
    }

    //钩子方法,决定是否需要添加配料
    boolean isAdd(){
        return true;
    }
}
