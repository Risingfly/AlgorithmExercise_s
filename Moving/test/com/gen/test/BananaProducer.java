package com.gen.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BananaProducer implements Runnable {
    private LinkedBlockingDeque queue;
    private int conNum;

    public BananaProducer(LinkedBlockingDeque queue, int conNum){
        this.queue = queue;
        this.conNum = conNum;
    }
    @Override
    public void run() {
        System.out.println("生产香蕉：");
        byte[] bytes = new byte[1024*1024*100];
//        Object[] obj = new Object[1024*1024*100];
        int i = 0;
        for (;;) {

            try {
                System.out.println("生产香蕉："+(++i));
                Thread.sleep(100);
                queue.put("香蕉："+i+bytes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        for (int i = 0; i < conNum; i++) {
//
//        }
    }
}
