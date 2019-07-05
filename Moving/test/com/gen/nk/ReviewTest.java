package com.gen.nk;

public class ReviewTest {
    public static void main(String[] args) {
        String s = new String("abcd");
        String a =  "aa".intern();
        String a1 = "aa";
        String a2 = new String("aa");
        System.out.println(a == a1);
        System.out.println(a == a2);
        System.out.println(s);
        short b = 1;
        int b1 = 1;
        float c = 1.1f;
    }
}
