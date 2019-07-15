package com.gen.test2;

public class Parent {
    public static int a = 1;
    static {
        a = 100;
        System.out.println("init="+a);
    }

    public static void main(String[] args) {
//        Parent p = new Parent();
        System.out.println(Parent.a);
        System.out.println("b="+SubParent.b);
    }
}
