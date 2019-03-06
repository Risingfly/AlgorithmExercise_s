package com.gen.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BananaConsumer  implements  Runnable{

    private LinkedBlockingDeque queue;
    public BananaConsumer(LinkedBlockingDeque queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        System.out.println("开始消费香蕉：");
        for (;;) {
            try {
                System.out.println("当前线程==》"+Thread.currentThread().getName()+"消费："+queue.take());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
