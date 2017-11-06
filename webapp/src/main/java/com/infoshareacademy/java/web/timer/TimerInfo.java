package com.infoshareacademy.java.web.timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

@Singleton
public class TimerInfo {

    private final Logger logger = LogManager.getLogger(getClass());

    LocalDateTime lastRun;
    Duration lengthOfTime;

    TimerConfiguration timerConfiguration = new TimerConfiguration();
    TimerJsonReader timerJsonReader = new TimerJsonReader();


    @PostConstruct
    void initializeTimerInfo() {
        logger.log(Level.INFO, "obiekt TimerInfo zostal utworzony");

        ResourceReader resourceReader = new ResourceReader();
        String json = resourceReader.getStringFromResource("reportMailSenderConfig.json");
        try {
            timerConfiguration = timerJsonReader.readJsonFile(json);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        lastRun = LocalDateTime.now();
        logger.log(Level.INFO, "lastRun=" + lastRun);
        lengthOfTime = Duration.ofSeconds(timerConfiguration.getLengthOfTime());
        logger.log(Level.INFO, "lengthOfTime=" + lengthOfTime);
    }

    public boolean getInfo() {
        LocalDateTime now = LocalDateTime.now();
        if (lastRun.plus(lengthOfTime).isBefore(now)) {
            logger.log(Level.INFO, "TimefInfo.getInfo=true - aktywowanie triggera");
            lastRun = LocalDateTime.now();
            return true;
        }
        logger.log(Level.INFO, "TimefInfo.getInfo=false - trigger nieaktywowany");
        return false;
    }
}
