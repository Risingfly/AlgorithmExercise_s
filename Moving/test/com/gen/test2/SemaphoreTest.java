package com.gen.test2;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Integer count = 0;
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(0);
    class Pro implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                UtilSleep.sleep(1000);
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()+"pro= "+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }

            }
        }
    }
    class Con implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                UtilSleep.sleep(1000);
                try {
                    notEmpty.acquire();
//                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()+"Con = "+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    mutex.release();
                    notFull.release();
                }
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreTest test = new SemaphoreTest();
        new Thread(test.new Pro()).start();
        new Thread(test.new Pro()).start();
        new Thread(test.new Pro()).start();
        new Thread(test.new Con()).start();
        new Thread(test.new Con()).start();
        new Thread(test.new Con()).start();
    }
}
