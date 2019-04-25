package com.gen.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args)throws IOException {
        while (true){
            Socket socket = new Socket("127.0.0.1",66);
//            自己想对服务器说的
            OutputStream out  = socket.getOutputStream();
            System.out.println("请输入：");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            out.write(msg.getBytes());
//          阻塞，一直阻塞等待服务端回话，若不回话则一直阻塞
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            in.read(bytes);
            System.out.println("老板说："+new String(bytes).trim());
            socket.close();
        }
    }
}
