package com.gen.test2;

import java.util.concurrent.Semaphore;

public class SemaphoreTest2 {
    private static int a = 100;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        new Thread(){
            @Override
            public void run() {
                try {
//                    semaphore.acquire();
                    semaphore.release();
                    semaphore.release();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("释放");
//                System.out.println("a="+(--a));
//                semaphore.release();
            }
        }.start();
        Thread t =  new Thread(){
            @Override
            public void run() {
                for (;;){
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("a="+(--a));
                    semaphore.release();

                }

            }
        };
        t.start();
    }
}
