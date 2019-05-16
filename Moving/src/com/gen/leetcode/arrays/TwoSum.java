package com.gen.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 问题：1
 * 核心思路：将数组中的值作为key,下标作为value，这样每次查找键 target - key（数组值）是否存在
 * 若存在说明有这样的数对
 * @author Genge
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
//        如注释所示，不能先添加map,因为会出现键值覆盖，如3，3 6
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println("input target");
        int target = in.nextInt();

        twoSum(nums,target);
    }
}
