package com.gen.nk;



import java.util.Arrays;
import java.util.Scanner;

public class ShopeeTest2 {
    public static void main(String[] args) {
        ShopeeTest obj   = new ShopeeTest();
        System.out.println(obj.getClass());
        String str1 = "爱讯飞789swrlwwen34ifly65tek";
            if (slove(str1) == null){
                System.out.println(-1);
            }else {
                System.out.println(new String(slove(str1)));
            }
    }
    private static char[] slove(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num >= 0 && num <= 9){
                sb.append(str.charAt(i));
            }
        }
        String tmp = sb.toString();
        if (tmp.length() == 0){
            return null;
        }

        char[] nums = tmp.toCharArray();
        Arrays.sort(nums);
        return nums;
    }
}
