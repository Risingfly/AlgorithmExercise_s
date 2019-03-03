package com.gen.test;

public class AppleConsumer implements Runnable{
    private AppleBox appleBox;
    public AppleConsumer(AppleBox appleBox){
        this.appleBox = appleBox;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            try {
                System.out.println("Con i="+i);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            appleBox.decrease();

        }
    }
}
