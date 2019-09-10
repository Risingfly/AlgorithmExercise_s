package com.gen.online;

import java.util.Scanner;

public class AiQiYi2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int m = read.nextInt();
            double res = n/(n + m) + m/(n + m) * n/(n + m - 1) * (n/(n + m - 2) * (n - 1)/m
            + (n - 1)/(n + m - 2) * n/m) +m/(n + m) * n/(n + m - 1) * n/(n + m - 2) * (n - 1)/m
                    * 1/3;
            String str = String.format("%.5f",res);
            System.out.println(str);
        }
    }
}
