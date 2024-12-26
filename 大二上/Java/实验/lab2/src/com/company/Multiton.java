package com.company;
public class Multiton {
    private static final int N=10;
    private int num;
    private Multiton(int n){
        num=n;
        System.out.println("创建第"+num+"个实例");
    }
    public int getNum() {
        return num;
    }


    public static Multiton[] list= new Multiton[10];
    //实例化N个对象
    static{
        for(int i=0;i<N;i++){
             list[i]=new Multiton(i+1);
        }
    }
    private static int n=0;
    //不能将方法体内的局部变量声名为static,所以在方法外定义,可用对象或类名调用
    public static Multiton getInstance() {
        if(n<N) return list[n++];
        else return list[0];
    }
    //随机获得实例对象
     public static Multiton getRandomInstance() {
        // 获得随机数字
         int n = (int) (Math.random() * N);
         // 获得list中的对象实例
         return list[n];
         //这里要用到list，所以list创建在main外.静态方法只能访问静态成员
    }

    public static void main(String[] args) {
        Multiton[] a=new Multiton[N+1];
        for(int i=0;i<N+1;i++){
            a[i]=Multiton.getInstance();
            System.out.println("获取实例:第"+a[i].getNum()+"个");
        }
        Multiton mutiton1=Multiton.getRandomInstance();
        System.out.println("获取实例1:第"+mutiton1.getNum()+"个");
        Multiton mutiton2=Multiton.getRandomInstance();
        System.out.println("获取实例2:第"+mutiton2.getNum()+"个");
        if(mutiton1==mutiton2) System.out.println("这是同一个实例");
        else System.out.println("这不是同一个实例");
    }
}
