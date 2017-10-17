package com.infoshareacademy.baseapp.email;

import javax.mail.MessagingException;

public class EmailTmp {

    public static void main(String[] args) {
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        try {
            email.send("infoshareokularnicy@wp.pl", "subject", "hello world");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
