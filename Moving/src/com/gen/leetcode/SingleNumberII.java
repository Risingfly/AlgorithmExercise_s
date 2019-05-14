package com.gen.leetcode;

/**
 *
 * 问题:137
 * 复杂度O(32n) == O(n)
 * @author Genge
 */
public class SingleNumberII {
    public int singleNumber(int[] nums){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
//          对数组的每个数都同时移动第i位,出现三次的数在对3取模过后必然为0
//          若sum不等于0,必定为出现一次的数,将其左移i位恢复其对应位的值
//          通过|或操作可以每次将对应的位置置1
//          最终结果即为出现一次的数
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1){
                    sum++;
//                  对3取模,表示每出现三次即清理一次
                    sum %= 3;
                }
            }
//          sum只可能为0或者1,为1必然是出现一次的数,恢复对应位置
            if (sum == 1){
                ans |= (sum << i);
            }
        }
        return ans;
    }
}
