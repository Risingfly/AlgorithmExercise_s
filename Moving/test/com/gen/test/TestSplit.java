package com.gen.test;

import java.util.Arrays;

public class TestSplit {
    public static void main(String[] args) {
        String str = "1,2,3";
        String[] str1 = str.split("\\|");
        System.out.println(str1[1]);
        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i]);
        }
    }
}
