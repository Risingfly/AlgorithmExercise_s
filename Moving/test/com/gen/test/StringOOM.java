package com.gen.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringOOM {
    private static int i = 0;
    private static void nb(){
        i++;
        System.out.println(str+"i= "+i);
        nb();
    }
   static String str = "牛逼";

    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();

        for (;;){
            Object obj = new Object();
//            nb();
            if (set.contains(obj)){
                break;
            }else {
                set.add(obj);
            }
        }
    }
}
