package com.gen.test2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTest implements Runnable{
    static class SingleClass{
        private static final SingleTest SINGLE_TEST = new SingleTest();
    }
    private static SingleTest getTest(){
        return SingleClass.SINGLE_TEST;
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new Thread(new SingleTest()));
        }
    }
    private static volatile SingleTest singleTest;
    private SingleTest(){}

    public static SingleTest getSingleTest() {
            if (singleTest == null){
                synchronized (SingleTest.class){
//                    if (singleTest == null){
                        singleTest = new SingleTest();
//                    }
                }
            }
        return singleTest;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+getTest());
    }
}
