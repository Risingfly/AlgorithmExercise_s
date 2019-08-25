package com.gen.online;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KuaiShou2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int m = Integer.parseInt(str1);
            for (int i = 0; i < m; i++) {
                String str2 = read.nextLine();
                int n = Integer.parseInt(str2);
                System.out.println(isHappyNum(n));
            }
        }
    }
    public static boolean isHappyNum(int n) {
        Set<Integer> sets = new HashSet<Integer>();
        int squareSum,remain;
        while (sets.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }
}
