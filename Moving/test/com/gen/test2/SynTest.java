package com.gen.test2;

import com.gen.test.SynObj;

public class SynTest implements Runnable{
    public  void test(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"获得锁");
        }
        for (;;){}
    }

    @Override
    public void run() {
        synchronized (this){
            test();
        }

    }

    public static void main(String[] args) {
        SynTest test = new SynTest();
        Thread t1 = new Thread(test,"t1");
        Thread t2 = new Thread(test,"t2");
        t1.start();
        t2.start();
    }
}
