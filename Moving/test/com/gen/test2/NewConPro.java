package com.gen.test2;

public class NewConPro {
    private static final Object LOCK = new Object();
    private static volatile int count = 0;
    private static final int EMPTY = 0;
    private static final int FULL = 1;
    private static boolean flag = false;
    static class Pro extends Thread{
        @Override
        public void run() {
            synchronized (LOCK){
                for (;;){
                    UtilSleep.sleep(1000);
                    while (FULL == count){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"==生产者生产: "+(++count));
                    LOCK.notifyAll();
                }

            }
        }
    }
    static class Con extends Thread{
        @Override
        public void run() {
            synchronized (LOCK){
                for (;;){
                    UtilSleep.sleep(1000);
                    while (EMPTY == count){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"===消费者消费:"+(--count));
                    LOCK.notifyAll();
                }

            }

        }
    }

    public static void main(String[] args) {
        Pro pro = new Pro();
        Pro pro1 = new Pro();
        Con con = new Con();
        Con con1 = new Con();
        pro.start();
//        pro1.start();
        con.start();
        con1.start();
    }
}
