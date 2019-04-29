package com.gen.test;

import java.util.Scanner;

public class Mains {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            happys(n);
        }
    }
    public static void happys(int n){
        int mod = -1;
//        int sh = -1;
        int count = 0;
        int all = 0;
        int N = n;
        while (n != 0){
            all++;
            mod = n % 10;
            if (mod == 0 || N % mod == 0){
                count++;
            }
            n = n / 10;
        }
        if (count == all){
            System.out.println("H");
        }else if (count == 0){
            System.out.println("S");
        }else {
            System.out.println("G");
        }
    }
}
