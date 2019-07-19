package com.gen.test2;

public class TestInterrupt implements Runnable{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
//            break;
        }
        System.out.println("666");
    }

    public static void main(String[] args) {
        TestInterrupt interrupt = new TestInterrupt();
        Thread t = new Thread(interrupt);
        t.start();
        t.interrupt();

    }
}
