package com.infoshareacademy.baseapp.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailMkyong {



    public static void main(String[] args) {
        Properties props = new Properties();
        //props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.wp.pl");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("infoshareokularnicy@wp.pl","okularnicY");
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("infoshareokularnicy@wp.pl"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("infoshareokularnicy@wp.pl"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler," +
                    "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
