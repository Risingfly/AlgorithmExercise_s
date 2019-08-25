package com.gen.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class KusaiShou3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(" ");
            String[] str2 = read.nextLine().split(" ");
            Stack<String> stack = new Stack<>();
            List<String> res = new ArrayList<>();
            for (int i = str2.length - 1; i >= 0; i--) {
                stack.push(str2[i]);
            }
            int count = 0;
            for (int i = 0; i < str1.length; i++) {
                ++count;
                res.add(str1[i]);
                while (count == 4 && !stack.isEmpty()){
                    res.add(stack.pop());
                    count = 0;
                }
            }
            while (!stack.isEmpty()){
                res.add(stack.pop());
            }
            for (String str : res){
                System.out.print(str+" ");
            }
        }
    }
}
