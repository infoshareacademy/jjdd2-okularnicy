package com.infoshareacademy.java.web.timer;

import com.infoshareacademy.baseapp.email.EmailService;
import com.infoshareacademy.baseapp.statistics.Report;
import com.infoshareacademy.baseapp.statistics.Statistics;
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

@Startup
@Singleton
public class Timer {

    private final Logger logger = LogManager.getLogger(getClass());
    TimerConfiguration timerConfiguration = new TimerConfiguration();
    TimerJsonReader timerJsonReader = new TimerJsonReader();
    String json;

    @Inject
    TimerInfo timerInfo;

    @PostConstruct
    void initializeTimer() {
        logger.log(Level.INFO, "obiekt Timer zostal utworzony");
        ResourceReader resourceReader = new ResourceReader();
        json = resourceReader.getStringFromResource("TimerConfig.json");
        try {
            timerConfiguration = timerJsonReader.readJsonFile(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Schedule(second = "0", minute = "*", hour = "*", persistent = false)
    public void doWork() {
        Report report = new Report();
        String message = report.getReport();

        EmailService email = new EmailService(timerConfiguration.getEmailLogin(),
                timerConfiguration.getEmailPass(),
                timerConfiguration.getEmailSmtpAdress(),
                timerConfiguration.getEmailPort());
        logger.log(Level.INFO, "sprawdzam czy nalezy wykonac zaplanowana akcje");
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
