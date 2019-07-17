package com.gen.test2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProConTest {
    private static final Lock lock = new ReentrantLock();
    private static Condition conA = lock.newCondition();
    private static Condition conB = lock.newCondition();
    private static Condition conC = lock.newCondition();
    private static long count = 0L;
    static class Pro extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (;;){
//                    if (count < 5){
//                        count++;
//                        System.out.println("conA"+"Pro-"+Thread.currentThread().getName()+
//                        "== count:"+count);
//                    }
                    UtilSleep.sleep(1000);
                    System.out.println("conA"+Thread.currentThread().getName());
                    try {
                        conB.signal();
                        conA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    lock.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("释放锁了");
                lock.unlock();
            }
        }
    }
    static class Con extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (;;){
//                    if (count > 0){
//                        count--;
//                        System.out.println("conB"+"Con-"+Thread.currentThread().getName()+
//                                "== count:"+count);
//                    }
                    UtilSleep.sleep(1000);
                    System.out.println("conB"+Thread.currentThread().getName());
                    try {
                        conC.signal();
                        conB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    static class Con1 extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (;;){
//                    if (count > 0){
//                        count--;
//                        System.out.println("conC"+"Con-"+Thread.currentThread().getName()+
//                                "== count:"+count);
//                    }
                    UtilSleep.sleep(1000);
                    System.out.println("conC"+Thread.currentThread().getName());
                    try {
                        conA.signal();
                        conC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Pro pro = new Pro();
        Con con = new Con();
        Con1 con1 = new Con1();
        pro.start();
        con.start();
        con1.start();
    }
}
