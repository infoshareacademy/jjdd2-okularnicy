package com.infoshareacademy.baseapp.email;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    String smtp;
    Integer port;
    String login;
    String pass;

    public Email(String smtp, Integer port, String login, String pass) {
        this.smtp = smtp;
        this.port = port;
        this.login = login;
        this.pass = pass;
    }

    public void send(String recipient, String subject, String content){
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(login,pass);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(login));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException e) {
            logger.log(Level.ERROR, "Wyjątek: IOException");
        }
    }
}
