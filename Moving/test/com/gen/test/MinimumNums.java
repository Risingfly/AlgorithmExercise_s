package com.gen.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNums {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length < k ){
            return new ArrayList<Integer>();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }
        for (int i = 0; i < input.length - k; i++) {
            pq.poll();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i:pq
             ) {
            list.add(i);
        }
        return list;
    }
}
