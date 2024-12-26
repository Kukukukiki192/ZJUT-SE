package cn.edu.zjut.java.ch04.subclassfieldVariable2;

public class Child2 extends AbstractParent {

    @Override
    public void printCommon() {
        System.out.print("common:" + common);
    }

    public void printParentCommon(){
        System.out.print("parent common:" + super.common);
    }
}
