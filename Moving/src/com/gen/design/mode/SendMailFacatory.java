package com.gen.design.mode;

public class SendMailFacatory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
