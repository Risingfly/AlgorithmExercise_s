package com.gen.online;

import java.util.*;

public class ByteDance3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int n = Integer.parseInt(read.nextLine());
            String[] str1 = read.nextLine().split(" ");
            int[] nums = new int[n];
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(Integer.parseInt(str1[i]));
            }
            List<Integer> me = new ArrayList<>();
            List<Integer> old = new ArrayList<>();
            while (!queue.isEmpty()){
                int tmpme = queue.peekFirst() > queue.peekLast() ? queue.pollFirst() : queue.pollLast();
                me.add(tmpme);
                if (!queue.isEmpty()){
                    int tmpold = queue.peekFirst() > queue.peekLast() ? queue.pollFirst() : queue.pollLast();
                    old.add(tmpold);
                }
            }
            int sum = 0;
            for(int num: me){
                sum += num;
            }
            System.out.println(sum);
        }
    }
}
