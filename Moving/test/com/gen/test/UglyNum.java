package com.gen.test;


import java.util.ArrayList;

public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
//        int i = 0;
        while (list.size() < index){
            int min = Math.min(list.get(i2) * 2,Math.min(list.get(i3) * 3,list.get(i5) * 5));
            list.add(min);
            if (min == list.get(i2) * 2){
                i2++;
            }
            if (min == list.get(i3) * 3){
                i3++;
            }
            if (min == list.get(i5) * 5){
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
    public int Add(int num1,int num2) {
        int tmp = 0;
        while (num2 != 0){
            tmp = num1 ^ num2;
            num2 = num1 & num2 << 1;
            num1 = tmp;
        }
        return num1;
    }


}
