package com.gen.test;

import com.gen.test2.UtilSleep;

public class ProConTest3 {
    private static final Object lock = new Object();
    private static volatile int count = 0;
    static class Pro extends Thread{
        @Override
        public void run() {
            for (;;){
                UtilSleep.sleep(1000);
                synchronized (lock){
                    while (count == 10){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"--remain: "+count);
                    lock.notifyAll();
                }
            }
        }
    }
    static class Con extends Thread{
        @Override
        public void run() {
            for (;;){
                UtilSleep.sleep(1000);
                synchronized (lock){
                    while (count == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"--remain: "+count);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Pro pro = new Pro();
        pro.setName("pro");
        Con con = new Con();
        con.setName("con");
        Pro pro1 = new Pro();
        pro.setName("pro1");
        Con con1 = new Con();
        con.setName("con1");
        UtilSleep.sleep(1000);
        con.start();
        pro.start();

        pro1.start();
        con1.start();
    }
}
