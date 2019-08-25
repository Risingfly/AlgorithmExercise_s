package com.gen.online;

import java.util.Scanner;

public class BeKe2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]);
            long m = Long.parseLong(str1[1]);
            int anum = 0;

            for (int i = 0; i < n; i++) {
                String[] str2 = read.nextLine().split(" ");
                int num = Integer.parseInt(str2[0]);
                long vol = Long.parseLong(str2[1]);
                int count = 0;
                for (int j = 1; j <= num; j++) {
                    if (vol * j <= m){
                        count++;
                    }else {
                        break;
                    }
                }
                m -= count * vol;
                anum += count;
            }
            System.out.println(anum);
        }
    }
}
