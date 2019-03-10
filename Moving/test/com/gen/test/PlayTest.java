package com.gen.test;

public class PlayTest extends Thread{
    private static int FULL = 10;
    private static int EMPTY = 0;
    volatile private static int count = 0;
    private final static Object lock = new Object();
    static class Con extends Thread{
        @Override
        public void run() {
            for (;;){
                synchronized (lock){
                    try {
                        Thread.sleep(10);
                        if (count <= EMPTY){
                            lock.wait();
                        }
                        count--;
                        System.out.println("当前线程："+Thread.currentThread().getName()+"正在消费，还剩："+
                                count+"个");
                        lock.notify();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    static class Pro extends Thread{
        @Override
        public void run() {
            for (;;){
                synchronized (lock){
                    try {
                        Thread.sleep(10);
                        if (count == FULL){
                            lock.wait();
                        }
                        count++;
                        System.out.println("当前线程："+Thread.currentThread().getName()+"正在生产，还剩："+
                                count+"个");
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
    @Override
    public void run() {
        int i = 0;
        for (;;){
            if (i++ == 100){
                break;
            }
            new Pro().start();
            new Con().start();
        }

    }

    public static void main(String[] args) {
        new PlayTest().start();
    }
}
