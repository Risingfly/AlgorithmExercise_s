package com.gen.test2;

import java.util.concurrent.*;

public class CountdownLatchExample {
    public static void main(String[] args)throws Exception {
        final int count = 2;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        CyclicBarrier barrier = new CyclicBarrier(4);
        Thread t1 = new Thread(new T(barrier),"t1");
        Thread t2 = new Thread(new T(barrier),"t2");
        Thread t3 = new Thread(new P(barrier),"t3");
        t1.start();
        t2.start();
        t3.start();
//        countDownLatch.await();
//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0; i < 9; i++) {
//            service.execute(()->{
//                System.out.println(Thread.currentThread().getName()+"--run..");
//                countDownLatch.countDown();
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            });
//        }
//        System.out.println(Thread.currentThread().getName()+">>>end");
//        service.shutdown();
    }
}
class P implements Runnable{
    private CyclicBarrier countDownLatch;
    public P(CyclicBarrier countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        for (;;){
            UtilSleep.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"调用await(),同时等待其他线程..await()");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            UtilSleep.sleep(3000);

//        System.out.println("大家都await()");
            System.out.println("Together Going:"+Thread.currentThread().getName());
            countDownLatch.reset();
        }

    }
}
class T implements Runnable{
    private CyclicBarrier countDownLatch;
    public T(CyclicBarrier countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        for (;;){
            System.out.println(Thread.currentThread().getName()+"run"+"调用await()方法");
//        countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("Together Going:"+Thread.currentThread().getName());
        }

    }
}