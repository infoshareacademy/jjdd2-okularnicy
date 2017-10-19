package com.infoshareacademy.baseapp.email;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;


public class EmailScheduler {
    public static void main(String[] args) {
        Scheduler scheduler=null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        // define the job and tie it to our MyJob class
        JobDetail job = newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }
}
