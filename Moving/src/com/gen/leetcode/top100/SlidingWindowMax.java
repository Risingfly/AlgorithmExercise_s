package com.gen.leetcode.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题：239
 * 思路：建立一个双向队列，每次从队尾入队并比较大小，若队尾小于等于则弹出，
 * 队头为窗口最大值，同时要确保队头未过期
 * @author Genge
 */
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int index = 0;
//        存放结果（有 数组长度 - k + 1个）
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
//            双向队列中存放数组对应下标，每次从队尾入队
//            比较时从队尾进行比较，若队尾小于等于当前值则从队尾弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
//            若队头的下标等于 i - k 表示队头过期，窗口已经走过该队头位置
            if (deque.peekFirst() == i - k){
                deque.pollFirst();
            }
//            只有i大于窗口值 - 1（从0开始）才会产生窗口大小
            if (i >= k - 1){
//                队头存放窗口目前最大值
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
