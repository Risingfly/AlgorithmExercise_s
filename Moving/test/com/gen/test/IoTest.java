package com.gen.test;

import java.io.*;

public class IoTest {
    public static void main(String[] args)throws IOException {
     Reader in = new InputStreamReader(new FileInputStream("C:\\Users\\genge\\Desktop\\新建文本文档.txt"));
     Writer out = new OutputStreamWriter(new FileOutputStream("E:\\4.txt"));
        int len = -1;
        char [] bytes = new char[1024];
        while ((len = in.read()) != -1){
//            out.flush();
            out.write(len);
        }
        out.close();
        in.close();
//        OutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\2.pdf"));
//        InputStream in = new  BufferedInputStream(new FileInputStream("C:\\Users\\genge\\Desktop\\三方协议书（20160226）.pdf"),100);
//        int len = -1;
//        byte [] bytes = new byte[10000];
//        while ((len = in.read(bytes)) != -1){
//            out.write(bytes);
//        }
//        in.close();
//        out.close();
//        OutputStream out = new FileOutputStream("E:\\2.txt");
//        OutputStream out1 = new FileOutputStream("E:\\2.jpg");
//
//        InputStream in = new FileInputStream("C:\\Users\\genge\\Desktop\\111.jpg");
//        int len = -1;
//        byte[] bytes = new byte[10240];
//        while ((len = in.read(bytes)) != -1){
//            out1.write(bytes);
        }


}
