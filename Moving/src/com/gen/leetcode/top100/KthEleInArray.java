package com.gen.leetcode.top100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题：215
 * 思路：建小根堆K,先入堆，当堆满时，弹出堆顶继续入直到数组结束；最后堆顶即为第K大
 *
 * 第k大--》最小堆 最小堆将小的元素全部弹掉，则剩下堆顶即为K大
 * 第K小--》最大堆 最大堆将大的元素全部弹掉，则剩下堆顶即为K小
 *
 * @author Genge
 */
public class KthEleInArray {
    public int findKthLargest1(int[] nums, int k){
//        k是从1开始数的，因此加1
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int e: nums) {
            queue.offer(e);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        int count = 0;
        int tmp = 0;
        while (count != k){
            tmp = queue.poll();
            count++;
        }
        return tmp;
    }
}
