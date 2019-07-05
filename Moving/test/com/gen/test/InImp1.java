package com.gen.test;

public class InImp1 implements Interface1 {
    @Override
    public void nb() {

    }

    @Override
    public void nb1() {
        System.out.println("真牛逼");
    }

    public static void main(String[] args) {
        InImp1 inImp1 = new InImp1();
        inImp1.nb();
        inImp1.nb1();
    }
}
