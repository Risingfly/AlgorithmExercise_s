package com.gen.sword.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 问题：滑动窗口问题
 * @author Genge
 */
public class SlideWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if (num == null || size < 1 || num.length < size ){
            return null;
        }
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
//        int index = 0;
        for (int i = 0; i < num.length; i++) {
//            双端队列中存放数组小标，且队列头永远存放最大的那个数下标
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]){
                queue.pollLast();
            }
//            若不大于队尾，直接入队尾
            queue.addLast(i);
//            此时遍历到i 双端队列对头为i -size 则队尾减队头:i - (i - size) = size
//            超过窗口1，头部节点过期，抛弃即可
            if (queue.peekFirst() == i - size){
                queue.pollFirst();
            }
//            从size - 1开始满足一个窗口，将头部节点放入list即可
            if (i >= size - 1){
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }
}
