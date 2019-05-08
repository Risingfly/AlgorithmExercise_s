package com.gen.test;

import java.util.Scanner;

public class PinDuoDuo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += in.nextInt();
        }
        int res = sum - N;
        System.out.println(res);
    }
}
