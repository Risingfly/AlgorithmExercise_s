package com.gen.sword.offer;

import java.util.ArrayList;

/**
 * 问题：有多少种连续的正数序列的和为sum(至少包括两个数)。
 * @author Genge
 */
public class ContinusPositiveNumSum {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 1;
        int r = 2;
        while (l < r){
            int cur = ((l + r) * (r - l + 1)) >> 1;
            if (cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r ; i++) {
                    list.add(i);
                }
                res.add(list);
                l++;
            }else if (cur < sum){
                r++;
            }else {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 1;
        FindContinuousSequence(a);
    }
}
