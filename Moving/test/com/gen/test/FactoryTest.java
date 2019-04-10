package com.gen.test;

import com.gen.design.mode.*;

public class FactoryTest {
    public static void main(String[] args) {
        Sender s1 = SendFactory.producer("邮件");
        s1.send();
        Sender s2 = SendFactory.produceSms();
        s2.send();

        Provider p1 = new SendMailFacatory();
        Sender s3 = p1.produce();
        Provider p2 = new SendSmsFactory();
        Sender s4 = p2.produce();
        s4.send();
    }
}
