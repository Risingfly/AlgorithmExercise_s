package com.gen.test4;

public class Test {
    public static void main(String[] args) {
        for (;;){
            System.out.println("offer棒棒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
