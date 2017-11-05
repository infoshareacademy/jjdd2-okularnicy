package com.infoshareacademy.java.web.timer;

import com.infoshareacademy.baseapp.email.EmailService;
import com.infoshareacademy.baseapp.statistics.Report;
import com.infoshareacademy.baseapp.statistics.Statistics;
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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Startup
@Singleton
public class Timer {

    private final Logger logger = LogManager.getLogger(getClass());
    TimerConfiguration timerConfiguration = new TimerConfiguration();
    TimerJsonReader timerJsonReader = new TimerJsonReader();
    private Statistics statistics = Statistics.getInstance();
    String json;

    @Inject
    TimerInfo timerInfo;

    @PostConstruct
    void initializeTimer  () {
        logger.log(Level.INFO, "obiekt Timer zostal utworzony");
        ResourceReader resourceReader = new ResourceReader();
        json = resourceReader.getStringFromResource("TimerConfig.json");
        try {
            timerConfiguration = timerJsonReader.readJsonFile(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Schedule(second="*", minute="*/1",hour="*", persistent=false)
    public void doWork(){
        Report report = new Report();
        String message = report.getReport();




        EmailService email = new EmailService(timerConfiguration.getEmailLogin(), timerConfiguration.getEmailPass(), timerConfiguration.getEmailSmtpAdress(), timerConfiguration.getEmailPort());
        logger.log(Level.INFO, "udalo sie!");
        boolean response = timerInfo.getInfo();
        logger.log(Level.INFO, "response=" + response);
        if (response) {
            try {
                email.send(timerConfiguration.getTargetEmail(), "Scheduled report", message);
                logger.log(Level.INFO, "email has been sent");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }


}

