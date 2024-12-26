package cn.edu.zjut.java.ch04.interfacedemo;


interface I
{
	void setValue(int val);
	int getValue();
}


public class InterfaceTest implements I {

    int value;
    public void setValue(int val){value=val;}
    //void setValue(int val){value=val;}

	@Override
	public int getValue() {
		return 0;
	}
}
