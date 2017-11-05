package com.infoshareacademy.java.web.timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.time.Duration;
import java.time.LocalDateTime;

@Singleton
public class TimerInfo {

    private final Logger logger = LogManager.getLogger(getClass());

    LocalDateTime lastRun;
    Duration setLengthOfTime;

    @PostConstruct
    void initializeTimerInfo () {
        logger.log(Level.INFO, "obiekt TimerInfo utworzony");
        lastRun = LocalDateTime.now();
        logger.log(Level.INFO, "lastRun=" + lastRun);
        setLengthOfTime = Duration.ofSeconds(3);

        logger.log(Level.INFO, "setLengthOfTime=" + setLengthOfTime);
    }

    public boolean getInfo(){
        LocalDateTime now = LocalDateTime.now();
        if (lastRun.plus(setLengthOfTime).isBefore(now)) {
            logger.log(Level.INFO, "minelo");
            lastRun = LocalDateTime.now();
            return true;
        }
        logger.log(Level.INFO, "jeszcze nie");
        return false;
    }



}
