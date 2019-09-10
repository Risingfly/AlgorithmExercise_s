package com.gen.online;

import java.util.*;

public class QTiger {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            String[] str2 = read.nextLine().split(" ");
            String pid = read.nextLine();
            Map<String,String> map = new HashMap<>();
            for (int i = 0; i < str1.length; i++) {
                map.put(str1[i],str2[i]);
            }
            Queue<String> queue = new LinkedList<>();
            queue.offer(pid);
            System.out.println(getNums(queue,map) + 1);
        }
    }
    private static int getNums(Queue<String> queue, Map<String,String> map){
        if (queue.isEmpty()){
            return count;
        }
        String pid = queue.poll();
        for (Map.Entry<String,String> entry : map.entrySet()){
            if (entry.getValue().equals(pid) && !entry.getValue().equals("0")){
                count++;
                queue.offer(entry.getKey());
            }
        }
//        count++;
//        queue.poll();
        getNums(queue,map);
        return count;
    }
}
