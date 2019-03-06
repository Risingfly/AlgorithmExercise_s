package com.gen.test;

public class InterruptTest extends Thread{
    @Override
    public void run() {
       synchronized (this){
           try {
               wait();
           } catch (InterruptedException e) {
               System.out.println("等待线程中断！！！！");
           }

       }

    }

    public static void main(String[] args) {
        try {
            InterruptTest it = new InterruptTest();
//            InterruptTest it2 = new InterruptTest();

//            it2.start();
//            Thread.sleep(1000);
            it.start();
            System.out.println("state="+it.getState());
            it.interrupt();
            Thread.sleep(1000);
            System.out.println("state="+it.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
