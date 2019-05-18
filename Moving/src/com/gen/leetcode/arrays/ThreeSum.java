package com.gen.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：15
 * 思路：将3sum转换为2sum（通过 target = 0 - num[i] ,剩下二者之和等于target即可）,
 * 先将数组排序，然后通过双指针逼近，同时在相等的地方通过l++ r--去掉重复的地方（因为数组排过序，所以可用此法去重）
 * @author Genge
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != num[i - 1]){
                int l = i + 1, r = num.length -1;
                int sum = 0 - num[i];
                while (l < r){
                    if (num[l] + num[r] == sum){
                        res.add(Arrays.asList(num[i],num[l],num[r]));
//                        因为该数组事先排过序，所以此处用来去重
                        while (l < r && num[l] == num[l + 1]) l++;
                        while (l < r && num[r] == num[r - 1]) r--;
                        l++;
                        r--;
                    }else if (num[l] + num[r] < sum){
                        l++;
                    }else {
                        r--;
                    }

                }
            }
        }
        return res;
    }
}
