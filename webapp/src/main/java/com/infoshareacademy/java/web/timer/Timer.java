package com.infoshareacademy.java.web.timer;

import com.infoshareacademy.baseapp.email.EmailService;
import com.infoshareacademy.java.web.beans.UserFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.mail.MessagingException;

@Startup
@Singleton
public class Timer {

    private final Logger logger = LogManager.getLogger(getClass());

    @Inject
    TimerInfo timerInfo;

    @PostConstruct
    void initializeTimer  () {
        logger.log(Level.INFO, "obiekt Timer utworzony");

    }

    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void doWork(){
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        logger.log(Level.INFO, "udalo sie!");
        boolean response = timerInfo.getInfo();
        logger.log(Level.INFO, "response=" + response);
        if (response) {
            try {
                email.send("infoshareokularnicy@wp.pl", "subject", "hello world");
                logger.log(Level.INFO, "email has been sent");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }


}

