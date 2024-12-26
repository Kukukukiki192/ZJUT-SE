package com.pattern.singleton.eg1;

/**
 * 懒汉式
 * 类加载时没有生成单例，只有当第一次调用getlnstance方法时才创建
 */
public class LazySingleton {
    /**
     * volatile在Java并发编程中常用于保持内存可见性和防止指令重排序
     * 声明变量是volatile的，JVM保证了每次读变量都从内存中读，跳过CPU cache这一步.在读取volatile类型的变量时总会返回最新写入的值
     */
    private static volatile LazySingleton instance = null; //保证instance在所有线程中同步

    //private 避免类在外部被实例化
    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
