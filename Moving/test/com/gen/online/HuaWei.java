package com.gen.online;

import java.util.Scanner;

public class HuaWei {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int l = read.nextInt();
            System.out.println(slove(l));
        }
    }
//    ans = 0;
//    cin >> l;
//for (int i = 1; i < l / 3; i++) {
//        double j = l - (double) l * l / (2 * l - 2 * i);
//        if (i < j && j - (int) j < 1e-5) {
//            ans++;
//        }
//    }
//    cout << ans << '\n';

    private static int slove(int l){
        int res = 0;
        for (int i = 1; i < l/3; i++) {
            double j = l - (double) l * l / (2 * l - 2 * i);
            if (i < j && j - (int)j < 1e-5){
                res++;
            }
        }
        return res;
    }
}
