package com.gen.nk;

import java.util.Arrays;

public class ATest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.length();
        String str = "123";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.println(arr);
        System.out.println(sb.toString().length());
//        sbv.append('c');
    }
}
