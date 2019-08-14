package com.gen.test3;

import java.util.HashSet;
import java.util.Scanner;

public class TigerTest3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);

            String[] str2 = read.nextLine().split(" ");
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(str2[i - 1]);
            }

            String[] str3 = read.nextLine().split(" ");
            int q = Integer.parseInt(str3[0]);

            for (int i = 0; i < q; i++) {
                String[] str4 = read.nextLine().split(" ");
                int l = Integer.parseInt(str4[0]);
                int r = Integer.parseInt(str4[1]);
                System.out.println(solve(a,l,r,m));
            }
        }
    }
    private static int solve(int[] a,int l,int r,int m){
//        int[] tmp = new int[m + 1];
//        for (int i = l; i <= r; i++) {
//            tmp[a[i]]++;
//        }
//        int count = 0;
//        for (int i = 1; i <= m; i++) {
//            if (tmp[i] >= 1){
//                count++;
//            }
//        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            set.add(a[i]);
        }
        return set.size();
    }
}
