package com.gen.sword.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题：中位数问题
 * 思路：将数据流分成了两个部分，从中间切分（想象一下数据流有序时的样子），
 * 大根堆里面是小的一半，小根堆大的一半，
 * 当求中位数时只用关心中间的一个数或者两个数，这时关心的数就是堆顶的数
 * 即（大的部分里最小的，小的部分里最大的，这俩者必有之一或取平均数为，中位数）
 * @author Genge
 */
public class MidNum {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
//        偶数先经过大根堆筛选再进入小堆（选当前最大值）
        if (count % 2 == 0){
            maxHeap.offer(num);
            int filtMax = maxHeap.poll();
            minHeap.offer(filtMax);
        }else {
//         奇数先经过小根堆筛选再进入大根堆（选当前最小值）
            minHeap.offer(num);
            int filtMin = minHeap.poll();
            maxHeap.offer(filtMin);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0){
            return new Double((maxHeap.peek() + minHeap.peek()))/2;
        }else {
            return new Double(minHeap.peek());
        }
    }
}
