package com.gen.nk;

import java.util.Scanner;

public class Dji {
    public static int getSolve(int bugnums,int effeic,int[] bugtime,int maxcup){
        int sum = 0;
        for (int i = 0; i < bugnums; i++) {
            sum += bugtime[i];
        }
        int mod = sum % 60;
        int time = sum / 60;
        int res = 0;
        if (time <= maxcup){
            res = sum / effeic;
        }else {
            res = (maxcup * 60)/effeic + (sum - (maxcup * 60));
        }
        return res > 480 ? 0 : res;
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int bugnums = read.nextInt();
            int effeic = read.nextInt();
            int maxcup = read.nextInt();
            int[] bugtime = new int[bugnums];
            for (int i = 0; i < bugnums; i++) {
                bugtime[i] = read.nextInt();
            }
            System.out.println(getSolve(bugnums,effeic,bugtime,maxcup));
        }
        read.close();
    }


}
