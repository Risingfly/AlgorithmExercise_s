package com.gen.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CdlTest {
    public static void main(String[] args)throws Exception {
        final int num = 5;
        CountDownLatch cdl = new CountDownLatch(num);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            service.execute(()->{
                cdl.countDown();
                System.out.println("name= "+Thread.currentThread().getName()+
                "   num= "+cdl.getCount());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        cdl.await();
        System.out.println(Thread.currentThread().getName()+"  run...");
    }
}
