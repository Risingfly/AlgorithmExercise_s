package com.gen.test;

public class WaitNotifyInstance {
   volatile public static boolean flag = false;
    public static void main(String[] args) throws InterruptedException{
        SynObj synObj = new SynObj();
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                synchronized (synObj){
                    while (flag){
                        System.out.println("我是消费者！");
                        try {
                            synObj.wait();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
                System.out.println("消费完毕@@@@");
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                synchronized (synObj){
                    while (flag){
                        System.out.println("我是生产者！");
                        flag = true;
                        synObj.notify();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
                System.out.println("生产完毕@@@@");
            }
        };

        Thread t1 = new Thread(run1,"run1");
        Thread t2 = new Thread(run2,"run2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
