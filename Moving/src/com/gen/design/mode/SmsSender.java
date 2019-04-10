package com.gen.design.mode;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("这时短信发送的消息。");
    }
}
