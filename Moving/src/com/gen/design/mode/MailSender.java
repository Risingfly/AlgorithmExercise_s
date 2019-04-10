package com.gen.design.mode;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("这是邮件系统发送的消息。");
    }
}
