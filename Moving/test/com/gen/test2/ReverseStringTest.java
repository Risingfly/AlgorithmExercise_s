package com.gen.test2;

public class ReverseStringTest {
    public static void main(String[] args) {
        String str = "  I am student  ";
        reverseSentence(str);

//        System.out.println(reverseSentence(str));
    }
    public static char[] reverse(char[] chars, int l, int r){
        char tmp;
        while (l < r){
            tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return chars;
    }
    public static String reverseSentence(String str){
        if (str == null || str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        //先反转整个字符串，即倒置它
        reverse(chars,0,chars.length - 1);
        //解决开头的问题
        //以空格为界限反转单词
        int blank = -1;
        int nextBlank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        //最后一个空格到结尾
        reverse(chars,nextBlank + 1,chars.length - 1);

        return new String(chars);
    }
}
