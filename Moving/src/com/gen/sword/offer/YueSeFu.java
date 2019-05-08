package com.gen.sword.offer;

public class YueSeFu {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        int i = -1;
        int count = n;
        int step = 0;
        int[] arr = new int[n];

        while (count > 0){
            i++;
            if (i >= n){
                i = 0;
            }
//            遇到-1跳过，模拟多圈
            if (arr[i] == -1){
                continue;
            }
//            真正走过的步骤
            step++;
            if (step == m){
                arr[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }
}
