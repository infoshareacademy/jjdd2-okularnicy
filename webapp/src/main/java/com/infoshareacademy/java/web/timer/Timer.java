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
import java.io.IOException;
import java.io.InputStream;

@Startup
@Singleton
public class Timer {

    private final Logger logger = LogManager.getLogger(getClass());
    TimerConfiguration timerConfiguration = new TimerConfiguration();
    TimerJsonReader timerJsonReader = new TimerJsonReader();

    @Inject
    TimerInfo timerInfo;

    @PostConstruct
    void initializeTimer  () {
        logger.log(Level.INFO, "obiekt Timer utworzony");

    }

    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void doWork(){
        String json = "";
        InputStream is = getClass().getClassLoader().getResourceAsStream("TimerConfig.json");
        logger.log(Level.INFO, "ABCDInputStream=" + is);
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.log(Level.INFO, "JSON=" + json);
        try {
            timerConfiguration = timerJsonReader.readJsonFile(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EmailService email = new EmailService(timerConfiguration.getEmailLogin(), timerConfiguration.getEmailPass(), timerConfiguration.getEmailSmtpAdress(), timerConfiguration.getEmailPort());
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

