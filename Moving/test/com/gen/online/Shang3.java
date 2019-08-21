package com.gen.online;

import java.util.Scanner;

public class Shang3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            long n = Long.parseLong(str1[0]);

            long a = Long.parseLong(str1[1]);
            long b = Long.parseLong(str1[2]);
            long c = Long.parseLong(str1[3]);
            long f0 = Long.parseLong(str1[4]);

            long res = slove(n,a,b,c,f0) % 1000000007;
            System.out.println(res);
        }
    }
    private static long slove(long n,long a,long b,long c,long f0){
        f0 = 32767;
        if (n == 0){
            return f0;
        }
        long f1 = a * f0 + 2 - 1 + 32767;
        if (n == 1){
            return f1;
        }
        long f2 = a * f1 + b * f0 + 8 - 2 + 32767;
        if (n == 2){
            return f2;
        }
        long f3 = a * f2 + b * f1 + f0 + 18 - 3 + 32767;
        if (n == 3){
            return f3;
        }
        long f = 0;
        for (long i = 4; i <= n; i++) {
            f = a * f3 + b * f2 + c * f1 + 2 * i * i - i + 32767;
            f1 = f2;
            f2 = f3;
            f3 = f;
        }
        return f;
    }
}
