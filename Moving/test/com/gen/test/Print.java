package com.gen.test;

import com.gen.test2.UtilSleep;

public class Print {
    private static final Object lock = new Object();
    static class A extends Thread{
        @Override
        public void run() {
            for (;;){
                synchronized (lock){
                    System.out.println("A");
                    lock.notifyAll();
                    UtilSleep.sleep(1000);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    static class B extends Thread{
        @Override
        public void run() {
            for (;;){
                synchronized (lock){
                    System.out.println("B");
                    lock.notifyAll();
                    UtilSleep.sleep(1000);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
    }
}
