package com.gen.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args)throws IOException {
//        创建serversocket对象
        ServerSocket ss = new ServerSocket(66);
        while (true){
//         监听阻塞，直到收到一个客户端请求
            Socket socket = ss.accept();
//         阻塞，看客户端要说什么
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            in.read(bytes);
            String clientIP = socket.getInetAddress().getHostAddress();
            System.out.println(clientIP + " say:" + new String(bytes).trim());
//         给客户端回话（不阻塞）
//            OutputStream out = socket.getOutputStream();
////            out.write("没钱".getBytes());
//            socket.close();
        }

    }
}
