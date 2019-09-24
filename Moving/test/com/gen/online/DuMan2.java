package com.gen.online;

import java.util.Scanner;

public class DuMan2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int t = Integer.parseInt(read.nextLine());
            for (int i = 0; i < t; i++) {
                String[] str1 = read.nextLine().split(" ");
                long A = Long.parseLong(str1[0]);
                long B = Long.parseLong(str1[1]);
                long p = Long.parseLong(str1[2]);
                long q = Long.parseLong(str1[3]);
                System.out.println(solve(A,B,p,q));
            }

        }
    }
    private static int solve(long A,long B,long p,long q){
        if (A >= B){
            return 0;
        }
        int count = 0;
        long tmp = 0;
        while (A <= B){

            count++;
            if ((tmp = A + p) >= B){
                break;
            }else {
                p *= q;
            }
        }
        return count;
    }
}
