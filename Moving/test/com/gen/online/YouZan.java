package com.gen.online;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class YouZan {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(",");
            int[] nums = new int[str1.length + 1];
            for (int i = 0; i < str1.length; i++) {
                if (isNumericZidai(str1[i])){
                    nums[i] = Integer.parseInt(str1[i]);
                }else {
                    String tmp = str1[i];
                    int index = 0;
                    for (int j = 0; j < tmp.length(); j++) {
                        if (tmp.charAt(j) == '|'){
                            index = j;
                            break;
                        }
                    }
                    nums[i] = Integer.parseInt(tmp.substring(0,index));
                    nums[++i] = Integer.parseInt(tmp.substring(index + 1,tmp.length()));
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int[] res = new int[set.size()];
            int j = 0;
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()){
                if (it.next() == 0){
                    continue;
                }
                res[j++] = it.next();
            }
            Arrays.sort(res);
            System.out.println(Arrays.toString(res));
        }
    }
    public static boolean isNumericZidai(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
