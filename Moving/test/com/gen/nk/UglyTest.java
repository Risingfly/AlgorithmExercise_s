package com.gen.nk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class UglyTest {
    /**
     * 开始位置为1，将该数乘以 2 3 5，选出最小值加入list,然后对应指针增加，
     * 每次比较对应指针位置取出的数乘以对应的2 3  5，选出最小对 加入list，最后返回
     * list最后一个元素即可
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        int p2 = 0,p3 = 0,p5 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < index){
            int min = Math.min(list.get(p2) * 2,Math.min(list.get(p3) * 3,list.get(p5) * 5));
            list.add(min);
            if (min == list.get(p2) * 2) p2++;
            if (min == list.get(p3) * 3) p3++;
            if (min == list.get(p5) * 5) p5++;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("res =  "+GetUglyNumber_Solution(0));
    }
}
