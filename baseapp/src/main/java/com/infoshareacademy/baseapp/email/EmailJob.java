package com.infoshareacademy.baseapp.email;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.MessagingException;

public class EmailJob implements org.quartz.Job{
    public EmailJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        try {
            email.send("infoshareokularnicy@wp.pl", "scheduled mail", "this is scheduled mail");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
