package com.gen.online;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baidu2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            int group = Integer.parseInt(read.nextLine());
            for (int i = 0; i < group; i++) {
                String[] str1 = read.nextLine().split(" ");
                int n = Integer.parseInt(str1[0]);
                Map<Integer,Node> map = new HashMap<>();
                for (int j = 1; j <= n; j++) {
                    map.put(j,new Node(j));
                }
                int m = Integer.parseInt(str1[1]);
                for (int j = 0; j < m; j++) {
                    String[] str2 = read.nextLine().split(" ");
                    int a = Integer.parseInt(str2[0]);
                    int b = Integer.parseInt(str2[1]);
                    map.get(a).next = map.get(b);
                }

            }
        }
    }
    private static int dfs(Node node){
        if (node.next == null){
            return -1;
        }
        return dfs(node);
    }
}
class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
}
