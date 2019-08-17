package com.gen.nk;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);

            int sum = 0;
            for (int i = 0; i < n; i++) {
                String[] str2 = read.nextLine().split(" ");
                for (int j = 0; j < str2.length; j++) {
                    sum += Integer.parseInt(str2[j]);
                }
            }
            int res = sum * 6 - sum * 2;
            System.out.println(res);
        }
    }
}
