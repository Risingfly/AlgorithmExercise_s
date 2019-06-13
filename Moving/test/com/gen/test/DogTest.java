package com.gen.test;

import java.lang.reflect.Field;

public class DogTest {
    public static void main(String[] args)throws Exception {
        Object dogg = Class.forName("com.gen.test.Dogg").newInstance();
        Object dog = Class.forName("com.gen.test.Dog").newInstance();
        Dogg dogg1 = (Dogg)dogg;
//        dogg.print();
        Class doggClazz = dogg.getClass();
        Field fieldname = doggClazz.getDeclaredField("name");
        Field fieldDog = doggClazz.getDeclaredField("dog");
        fieldname.setAccessible(true);
        fieldname.set(dogg,"牛逼");
        fieldDog.setAccessible(true);
        fieldDog.set(dogg,dog);
        System.out.println(dogg1.getDog());
        System.out.println(dogg1.getName());
//        System.out.println(dogg1.getName());
//        System.out.println(dogg1.getDog());
//        Dogg dogg2 = new Dogg();
//        System.out.println(dogg1);
//        System.out.println(dogg2);
    }
}
