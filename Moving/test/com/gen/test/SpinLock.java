package com.gen.test;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock extends Thread{
   volatile private static int i = 0;
    private AtomicReference<Thread> cas = new AtomicReference<>();
    public void lock(){
        Thread thread = Thread.currentThread();
        while (!cas.compareAndSet(null,thread)){

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        cas.compareAndSet(thread,null);
    }

    public void run(){

        lock();
        System.out.println("进入CAS锁中了。。。。");
        for (int j = 0; j < 100; j++) {
            i++;
//            if (i == 50){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        unlock();
        System.out.println("解锁了。。。。");
        System.out.println("lock i = "+i);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        spinLock.start();
        i++;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int a = 0;
        for (int j = 0; j < 100; j++) {
            a++;
        }
        System.out.println("a ="+a);
        System.out.println("main i = "+i);
    }
}
