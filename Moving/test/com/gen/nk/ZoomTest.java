package com.gen.nk;

import java.util.Scanner;

public class ZoomTest {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str = read.nextLine();
            String[] str1 = read.nextLine().split(" ");
            int m = Integer.parseInt(str1[0]);

            System.out.println(slove(str,m));
        }
    }
    private static String slove(String str,int m){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append('0');
        }
        String target = sb.toString();
        String[] str1 = str.split(target);
        String str2 = null;
        for (int i = 0; i < str1.length; i++) {
            str2 += str1[i];
        }
        return str2;
    }
}
