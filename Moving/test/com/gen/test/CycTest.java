package com.gen.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycTest {
    public static void main(String[] args) {
        final int threadNum = 5;
        CyclicBarrier cb = new CyclicBarrier(threadNum);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum - 1; i++) {
            es.execute(()->{
                System.out.println(Thread.currentThread().getName()+ "...  before run");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"begin run");
            });
        }
        es.shutdown();
    }
}
