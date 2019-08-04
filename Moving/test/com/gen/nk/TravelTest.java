package com.gen.nk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TravelTest {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int memNum = read.nextInt();
        int busNum = read.nextInt();
        int[] memSort = new int[memNum];
        for (int i = 0; i < memNum; i++) {
            memSort[i] = read.nextInt();
        }
        memSort = getSort(memSort,memNum,busNum);
        for (int i = 0; i < memNum; i++) {
            System.out.print(memSort[i] + " ");
        }
//        System.out.println(getSort(memSort,memNum,busNum).toString());
    }
    public static int[] getSort(int[] memSort,int memNum,int busNum){
        int[] arrRes = new int[memNum];
        int last = memNum % busNum;
        int every = memNum / busNum;
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int j = memSort.length - 1;

        for (int i = 0; i < last; i++) {
            stack.push(memSort[j--]);
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        int count = 0;
        while (j >= 0){
            while (count < busNum){
                stack.push(memSort[j--]);
                count++;
            }
            while (!stack.isEmpty()){
                res.add(stack.pop());
            }
            count = 0;
        }
        int k = 0;
        for (int num:res) {
            arrRes[k++] = num;
        }
        return arrRes;
    }
}
