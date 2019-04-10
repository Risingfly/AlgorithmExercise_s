package com.gen.design.mode;

public class SendFactory {
    public static Sender procucMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }
    public static Sender producer(String type){
        if (type.equals("邮件")){
            MailSender ms = new MailSender();
            return ms;
        }else if (type.equals("短信")){
            SmsSender ss = new SmsSender();
            return ss;
        }else {
            System.out.println("请输入正确的类型。");
            return null;
        }
    }
}
