package com.gen.test2;

import java.util.concurrent.CountDownLatch;

public class TestStatic {
    static {
        i = 1;
//        可以赋值，但不能访问
//        System.out.println(i);
    }
    static int i = 1;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int j = 0; j < 4; j++) {
            countDownLatch.countDown();
        }
        char z = 'A';
        char Z = 'Z';
        System.out.println("z="+(z - '0'));
        System.out.println("Z="+(Z - '0'));

    }
}
