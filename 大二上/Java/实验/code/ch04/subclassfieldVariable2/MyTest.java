package cn.edu.zjut.java.ch04.subclassfieldVariable2;

public class MyTest {

	public static void main(String[] args) {
        Child1 child1 = new Child1();
        child1.common = 6;
        Child2 child2 = new Child2();
        Child2 child3 = new Child2();
        child3.common = 10;
        //¥Ú”°child1
        child1.printCommon();
        System.out.print("\n");
        child1.printParentCommon();
        System.out.print("\n");
        //¥Ú”°child2
        child2.printCommon();
        System.out.print("\n");
        child2.printParentCommon();
        //¥Ú”°child3
        System.out.print("\n");
        child3.printCommon();
        System.out.print("\n");
        child3.printParentCommon();
	}

}
