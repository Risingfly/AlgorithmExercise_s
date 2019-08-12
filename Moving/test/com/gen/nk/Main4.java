package com.gen.nk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = read.nextInt();
            int s = read.nextInt();
            backtrack(new ArrayList<Integer>(),n,s,s,1);
            count = count % 1000000007;
            System.out.println(count);

        }
    }
    private static void backtrack(List<Integer> tmp,int n,int s,int remain,int start){
//       当剩余小于0时，则表示没找到，故返回
        if (remain < 0){
            return;
        }else if (remain == 0 && tmp.size() == n){
            count++;
        }else {
            for (int i = start; i < s ; i++) {
                if (tmp.size() < n){
                    tmp.add(i);
                    backtrack(tmp,n,s,remain - i,i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}

