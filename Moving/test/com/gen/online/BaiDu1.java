package com.gen.online;

import java.util.Scanner;

public class BaiDu1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            long n = Long.parseLong(str1[0]);
            long m = Long.parseLong(str1[1]);
            long k = Long.parseLong(str1[2]);
            long min = Long.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                    long tmp = (n - i)*m;
                    if (tmp <= k){
                        min = Math.min(min,i);
                    }
            }
            System.out.println(min);
        }
    }
}
