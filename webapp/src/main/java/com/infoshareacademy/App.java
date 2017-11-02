package com.infoshareacademy;

import com.infoshareacademy.baseapp.email.EmailService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.MessagingException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.text.ParseException;

@ApplicationPath("/")
public class App extends Application {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    public App() throws ParseException {

        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        try {
            email.send("infoshareokularnicy@wp.pl",
                    "na starcie aplikacji", "ten mail zostal wyslany po starcie serwera");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        logger.log(Level.INFO, "wyslano e-mail");
    }

}
