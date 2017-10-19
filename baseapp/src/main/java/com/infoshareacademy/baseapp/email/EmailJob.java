package com.infoshareacademy.baseapp.email;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.MessagingException;

public class EmailJob implements org.quartz.Job {

    public EmailJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        try {
            email.send("infoshareokularnicy@wp.pl", "subject", "hello world");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
