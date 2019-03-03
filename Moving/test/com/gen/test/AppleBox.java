package com.gen.test;

public class AppleBox {
    private int count = 0;
    public synchronized void increase(){
        while (count == 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        count++;
        System.out.println("生产苹果成功！");
        notify();
    }

    public synchronized void decrease(){
        while (count == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        count--;
        System.out.println("消费苹果成功！");
        notify();
    }

    public static void main(String[] args) {
        AppleBox appleBox = new AppleBox();
        AppleProducer appleProducer = new AppleProducer(appleBox);
        AppleConsumer appleConsumer = new AppleConsumer(appleBox);

        Thread pro = new Thread(appleProducer);
        Thread con = new Thread(appleConsumer);

        pro.start();
        con.start();

    }
}
