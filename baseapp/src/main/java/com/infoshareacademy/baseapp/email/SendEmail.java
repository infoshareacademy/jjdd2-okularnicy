package com.infoshareacademy.baseapp.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void main(String[] args) {
        String to = "infoshareokularnicy@wp.pl";
        String from = "infoshareokularnicy@wp.pl";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        //properties.setProperty("smtp.wp.pl",host);
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is the Subject Line!");
            message.setText("This is actual message");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Sent message successfully....");
    }
}
