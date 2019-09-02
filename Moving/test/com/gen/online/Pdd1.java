package com.gen.online;

import java.util.*;

public class Pdd1 {
    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String[] str1 = read.nextLine().split(";");
            String[] nums = str1[0].split(",");
//            System.out.println(Arrays.toString(nums));
            int n = Integer.parseInt(str1[1]);
//            System.out.println(n);
            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                if ((num & 1) == 0){
                    even.add(num);
                }else {
                    odd.add(num);
                }
            }
            Collections.sort(even,comparator);
            Collections.sort(odd,comparator);
            int evenLen = even.size();
            if (evenLen > n){
                for (int i = 0; i < n; i++) {
                    if (i != n - 1){
                        System.out.print(even.get(i)+",");
                    }else {
                        System.out.println(even.get(i));
                    }
                }
            }else {
                int j = 0;
                int remain = n - evenLen;
                for (int i = 0; i < n; i++) {
                    if (i < evenLen){
                        System.out.print(even.get(i)+",");
                    }else {
                        if (j != remain){
                            System.out.print(odd.get(j)+",");
                        }else {
                            System.out.println(odd.get(j));
                        }
                        j++;
                    }
                }
            }
        }
    }
}
