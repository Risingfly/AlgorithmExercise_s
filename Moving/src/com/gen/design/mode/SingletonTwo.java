package com.gen.design.mode;

/***
 * 单例模式：静态内部类法
 * 静态内部类方式在Singleton类被装载时并不会立即实例化，
 * 而是在需要实例化时，调用getInstance方法，
 * 才会装载SingletonInstance类，从而完成Singleton的实例化。
 *
 * 在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的
 * 优点：避免了线程不安全，延迟加载，效率高。
 * @author Genge
 */
public class SingletonTwo {
    private SingletonTwo(){}
    private static class SingletonInstance{
        private static final SingletonTwo INSTANCE = new SingletonTwo();
    }
    public static SingletonTwo getSingletonInstace(){
        return SingletonInstance.INSTANCE;
    }
}
