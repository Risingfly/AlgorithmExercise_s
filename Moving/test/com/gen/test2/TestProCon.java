package com.gen.test2;

public class TestProCon {
    private static volatile int count;
    private static final Object lock = new Object();
    static class Pro extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                for (;;){
                    if ((count & 1) == 0 ){
                        System.out.println("Current Thread: "+Thread.currentThread().getName()
                                +"==product count= "+count);
                        count++;
                    }
                    UtilSleep.sleep(1000);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    static class Con extends Thread{

        @Override
        public void run() {
            synchronized (lock){
                for (;;){
                    if ((count & 1) != 0){
                        System.out.println("Current Thread: "+Thread.currentThread().getName()
                                +"==consume count= "+count);
                        count++;
                    }
                    UtilSleep.sleep(1000);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                Pro pro = new Pro();
                pro.start();
                Con con = new Con();
                con.start();
            }
//            Pro pro2 = new Pro();
//            Con con2 = new Con();
//            pro2.start();
//            con2.start();
        }
    }
}
