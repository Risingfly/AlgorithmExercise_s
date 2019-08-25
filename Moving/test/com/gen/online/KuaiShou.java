package com.gen.online;

import java.util.Scanner;

public class KuaiShou {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNext()){
            String str1 = read.nextLine();
            int m = Integer.parseInt(str1);
            for (int i = 0; i < m; i++) {
                String[] str2 = read.nextLine().split(" ");
                int res = compareToVersion(str2[0],str2[1]);
                if (res == -1){
                    System.out.println(true);
                }else {
                    System.out.println(false);
                }
            }
        }
    }
    public static int compareToVersion(String ver1, String ver2) {
        String[] levels1 = ver1.split("\\.");
        String[] levels2 = ver2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
