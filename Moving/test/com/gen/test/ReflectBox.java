package com.gen.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectBox {
    private  final int num;
    public ReflectBox(int num){
        this.num = num;
    }
    public static void main(String[] args)throws Exception {
        Class appleBox = Class.forName("com.gen.test.AppleBox");
        AppleBox box = (AppleBox) appleBox.newInstance();
        Field field = appleBox.getDeclaredField("count");
        field.setAccessible(true);
        field.set(box,100);
        System.out.println(field.get(box));
        Method method = appleBox.getDeclaredMethod("decrease",null);
        method.invoke(box,null);

    }
}
