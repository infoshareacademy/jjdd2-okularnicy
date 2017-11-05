package com.infoshareacademy.java.web;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Timer {

    private final Logger logger = LogManager.getLogger(getClass());

    @PostConstruct
    void initializeAdmin () {
        logger.log(Level.INFO, "obiekt utworzony");

    }

    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void doWork(){
        System.out.println("udalo sie!");
        logger.log(Level.INFO, "udalo sie!");
    }


}

