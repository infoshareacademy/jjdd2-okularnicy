package com.infoshareacademy.java.web.timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.InputStream;
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
    void initializeTimerInfo () {
        logger.log(Level.INFO, "obiekt TimerInfo utworzony");


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
        logger.log(Level.INFO, "getLengthOfTime=" + timerConfiguration.getLengthOfTime());
        logger.log(Level.INFO, "getUnzippeDir=" + timerConfiguration.getUnzippeDir());

        lastRun = LocalDateTime.now();
        logger.log(Level.INFO, "lastRun=" + lastRun);
        lengthOfTime = Duration.ofSeconds(timerConfiguration.getLengthOfTime());
        logger.log(Level.INFO, "lengthOfTime=" + lengthOfTime);


    }

    public boolean getInfo(){
        LocalDateTime now = LocalDateTime.now();
        if (lastRun.plus(lengthOfTime).isBefore(now)) {
            logger.log(Level.INFO, "minelo");
            lastRun = LocalDateTime.now();
            return true;
        }
        logger.log(Level.INFO, "jeszcze nie");
        return false;
    }



}
