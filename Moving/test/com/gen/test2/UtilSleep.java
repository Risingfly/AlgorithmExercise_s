package com.gen.test2;

public class UtilSleep {
    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
