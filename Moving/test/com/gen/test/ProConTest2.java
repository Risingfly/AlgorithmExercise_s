package com.gen.test;

import com.gen.test2.UtilSleep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProConTest2 {
    private static int count = 0;
    private static final Lock LOCK = new ReentrantLock();
    private static final Condition FULL = LOCK.newCondition();
    private static final Condition NOTFULL = LOCK.newCondition();
    static class Pro extends Thread{
        @Override
        public void run() {
            for (;;){
                UtilSleep.sleep(1000);
                LOCK.lock();
                try {
                    while (count == 10){
                        try {
                            NOTFULL.signal();
                            FULL.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"remain:"+count);
                    NOTFULL.signal();
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }
    static class Con extends Thread{
        @Override
        public void run() {
            UtilSleep.sleep(1000);
            LOCK.lock();
            try {
                while (count == 0){
                    try {
                        FULL.signal();
                        NOTFULL.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName()+"remain:"+count);
                FULL.signal();
            } finally {
                LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Pro pro = new Pro();
        pro.setName("pro");
        Con con = new Con();
        con.setName("con");
        pro.start();
        con.start();
    }
}
