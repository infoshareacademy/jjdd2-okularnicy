package com.infoshareacademy.java.web.timer;

public class TimerConfiguration {
    private Integer lengthOfTime;
    private String emailLogin;
    private String emailPass;
    private String emailSmtpAdress;
    private Integer emailPort;
    private String targetEmail;

    public Integer getLengthOfTime() {
        return lengthOfTime;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public String getEmailPass() {
        return emailPass;
    }

    public String getEmailSmtpAdress() {
        return emailSmtpAdress;
    }

    public Integer getEmailPort() {
        return emailPort;
    }

    public String getTargetEmail() {
        return targetEmail;
    }
}