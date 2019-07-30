package com.gen.design.mode.sfactory;

public class FactotyTest {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        factory.getTools("Triangle").draw();
        factory.getTools("Circle").draw();
//        System.out.println();
    }
}
