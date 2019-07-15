package com.gen.leetcode.top100;

/**
 * 问题：287
 * 思路：同环链表入口节点题（142 LinkedListCycleII）,快指针每次走两步nums[nums[fast]];
 * 慢指针每次走一步nums[slow],相遇即为环中某节点，此时将快指针重新从0开始，每次走一步，
 * 最后二者相遇即为重复节点
 * @author Genge
 */
public class FindDupicateNum {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
