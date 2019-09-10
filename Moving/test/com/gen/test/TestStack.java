package com.gen.test;

import java.util.BitSet;
import java.util.HashMap;

public class TestStack {
    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        long size = (1024 * 128);
//        ThreadGroup group = new ThreadGroup("Genge");
//        Thread t = new Thread(group,stackTest,"stack",size);
//        t.start();
        Thread t = new Thread(stackTest);
        t.setName("stack");
        t.start();
//        BitSet
    }
}
class StackTest extends Thread{
    private static int count = 0;
    public StackTest(){

    }
    @Override
    public void run() {
        print();
    }
    private void print(){
        count++;
        System.out.println("count= "+count);
        print();
    }
}