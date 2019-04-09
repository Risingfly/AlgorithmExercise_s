package com.gen.design.mode;

/**
 * 单例设计模式一：双重检查锁
 * 优点：线程安全；延迟加载；效率较高。
 * @author Genge
 */
public class Singleton {
    /**
     * volatile禁止指令重排序
     */
    private static volatile Singleton instance;

    /**
     * 禁止其他类私自实例化
     */
    private Singleton(){}
    public static Singleton getInstance(){
//        提高效率，不为空的不必进入锁
        if (instance == null){
//            类锁，同一时刻只有一个该类的对象能访问
            synchronized (Singleton.class){
//                以防生成多个对象
                if (instance == null){
                    /**
                     * 1. memory = allocate() ;//分配对象的内存空间
                     2. ctorInstance(memory) ;//初始化对象
                     3. instance = memory ;//引用指向内存空间
                     1.3可能发生重排==============
                     =============================
                     1. memory = allocate() ;//分配对象的内存空间
                     3. instance = memory ;//引用指向内存空间
                     //注意： 还没有初始化
                     2. ctorInstance(memory) ;//初始化对象
                     */
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
