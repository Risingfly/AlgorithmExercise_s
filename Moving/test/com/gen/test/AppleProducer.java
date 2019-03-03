package com.gen.test;

public class AppleProducer implements Runnable{
    private AppleBox appleBox;
    public AppleProducer(AppleBox appleBox){
        this.appleBox = appleBox;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            try {
                System.out.println("pro i="+i);
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            appleBox.increase();

        }
    }
}
