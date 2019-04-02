package com.gen.test;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PealTest {
    private static Lock lock = new ReentrantLock();
    private static final Condition con = lock.newCondition();
    private static final Condition pro = lock.newCondition();
    private static int count = 0;
    static class Con extends Thread{
        @Override
        public void run() {
            lock.lock();
            for (;;){

                try {
                    Thread.sleep(1000);
                    count--;
                    System.out.println("当前线程："+Thread.currentThread().getName()+
                    "在消费，还剩"+count);
                    pro.signal();
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Pro extends Thread{
        @Override
        public void run() {
            lock.lock();
            for (;;){

                try {
                    Thread.sleep(1000);
                    count++;
                    System.out.println("当前线程："+Thread.currentThread().getName()+
                            "在生产，还剩"+count);
                    con.signal();
                    pro.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        new Pro().start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Con().start();
        System.out.println("核心数："+Runtime.getRuntime().availableProcessors()
        );
        Pro pro = new Pro();
        Con con = new Con();
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,100,1000, TimeUnit.MILLISECONDS,queue);
        executor.execute(pro);
        executor.execute(con);

    }
}
