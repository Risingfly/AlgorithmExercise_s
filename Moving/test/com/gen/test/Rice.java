package com.gen.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Rice {
    private String taste;
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    public Rice(String taste){
        this.taste = taste;
    }
    public static void sleeping(int l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void eat(){
        System.out.println("it tastes good!");
    }
    public static void cook(){
        System.out.println("I cook well !");
    }

}
