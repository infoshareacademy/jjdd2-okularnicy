package com.infoshareacademy.baseapp.email;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.MessagingException;

public class MyJob implements org.quartz.Job {

    public MyJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello World!  MyJob is executing.");
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        System.out.println("po utworzeniu");
        try {
            email.send("infoshareokularnicy@wp.pl", "subject", "hello world");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("po wyslaniu");
    }


}
