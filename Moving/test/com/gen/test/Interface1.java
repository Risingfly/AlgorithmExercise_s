package com.gen.test;

public interface Interface1 {
    void nb();
    default void nb1(){
        System.out.println("牛逼");
    }
}
