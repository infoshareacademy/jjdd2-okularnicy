package com.infoshareacademy.baseapp.email;

import com.infoshareacademy.baseapp.report.Report;

import javax.mail.MessagingException;

public class EmailTmp {

    public static void main(String[] args) {
        Report report = Report.getInstance();
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        try {
            email.send("infoshareokularnicy@wp.pl", "report", report.generateReport());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
