package com.gen.sword.offer;

public class StringBlank {
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return str.toString();
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
