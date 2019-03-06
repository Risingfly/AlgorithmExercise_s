package com.gen.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class RunBanana {
    public static void main(String[] args) {
        LinkedBlockingDeque queue = new LinkedBlockingDeque(10);
        BananaProducer bp = new BananaProducer(queue,2);
        BananaConsumer bc = new BananaConsumer(queue);
        BananaConsumer bc2 = new BananaConsumer(queue);

        Thread t1 = new Thread(bp);
        Thread t2 = new Thread(bc,"bc");
        Thread t3 = new Thread(bc2,"bc2");

        t1.start();
        t2.start();
        t3.start();
    }
}
