package com.gen.test2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();
//        ScheduledExecutorService
        ExecutorService pool = Executors.newCachedThreadPool();
        Thread t1 = new Thread(()->{
            local.set(1);
            UtilSleep.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"--res="+local.get());
        });
        Thread t2 = new Thread(()->{
            local.set(2);
            UtilSleep.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"--res="+local.get());
        });
        local.set(100);
        pool.execute(t1);
        pool.execute(t2);
//        UtilSleep.sleep(10000);
        System.out.println(Thread.currentThread().getName()+"--res="+local.get());
        pool.shutdown();
        pool.shutdownNow();
    }
}
