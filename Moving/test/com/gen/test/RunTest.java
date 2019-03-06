package com.gen.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class RunTest {
    public static void main(String[] args) {
        Rice rice = new Rice("good");
        CookRice cookRice = new CookRice(rice);
        EatRice eatRice = new EatRice(rice);
        cookRice.start();
        eatRice.start();
        System.out.println("main over!");
    }
}
