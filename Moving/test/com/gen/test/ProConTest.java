package com.gen.test;

import com.gen.test2.UtilSleep;

public class ProConTest {
    private static volatile int  count = 0;
    private static final Object lock = new Object();
    static class Pro implements Runnable{

        @Override
        public void run() {
            for (;;){
                UtilSleep.sleep(1000);
                synchronized (lock){
                    if (count == 10){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"produce: 1,remain"+count);
                    lock.notifyAll();
                }
            }
        }
    }
    static class Con implements Runnable{
        @Override
        public void run() {
            for (;;){
                UtilSleep.sleep(1000);
                synchronized (lock){
                    if (count == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"consume:1,remain"+count);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Pro pro = new Pro();
        Pro pro1 = new Pro();
        Con con = new Con();
        Thread t1 = new Thread(pro,"pro");
        Thread t3 = new Thread(pro,"pro2");
        Thread t2 = new Thread(con,"con");
        t1.start();
        t2.start();
//        t3.start();

    }
}
