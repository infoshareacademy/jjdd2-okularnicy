package com.infoshareacademy.java.Timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Singleton;

@Startup
@Singleton
public class TimerService {

    private final Logger logger = LogManager.getLogger(getClass().getName());

    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "obiekt zainicjowany");
    }

//    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void doWork(){
        System.out.println("udalo sie!");
        logger.log(Level.INFO, "udalo sie!");
    }

}
