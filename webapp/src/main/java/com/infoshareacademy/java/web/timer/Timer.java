package com.infoshareacademy.java.web.timer;

import com.infoshareacademy.baseapp.email.EmailService;
import com.infoshareacademy.baseapp.statistics.Statistics;
import com.infoshareacademy.java.web.beans.UserFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Startup
@Singleton
public class Timer {

    private final Logger logger = LogManager.getLogger(getClass());
    TimerConfiguration timerConfiguration = new TimerConfiguration();
    TimerJsonReader timerJsonReader = new TimerJsonReader();
    private Statistics statistics = Statistics.getInstance();

    @Inject
    TimerInfo timerInfo;

    @PostConstruct
    void initializeTimer  () {
        logger.log(Level.INFO, "obiekt Timer utworzony");

    }

    @Schedule(second="*/1", minute="*",hour="*", persistent=false)
    public void doWork(){
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

        Duration duration1;
        Duration duration2;
        duration1 = Duration.ofDays(7)
                .plusHours(0)
                .plusMinutes(0)
                .plusSeconds(0);
        duration2 = Duration.ofDays(30)
                .plusHours(0)
                .plusMinutes(0)
                .plusSeconds(0);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime last1 = now.minus(duration1);
        LocalDateTime last2 = now.minus(duration2);

        StringBuilder sb = new StringBuilder();

        sb.append("<H1>STATYSTYKI</H1>");

        sb.append("<table class=\"center\">");
        sb.append("<tr class=\"tr1st\">");
        sb.append("<td class=\"left\"><H3>Liczba wyborów użytkownika w pierwszym przedziale czasu</H3>");
        sb.append("<p>(dni:7, godziny:0, minuty:0, sekundy:0)</p></td>");
        sb.append("<td><H3>" + statistics.getNumberOfVisits(last1, now) + "</H3></td>");
        sb.append("</tr>");
        Map<String, Integer> numberOfVisitsEachName = statistics.getOccurrenceMap(last1, now);
        Set<Entry<String, Integer>> entries = numberOfVisitsEachName.entrySet();
        for(Entry<String, Integer> entry : entries){
            sb.append("<tr>");
            sb.append("<td class=\"left\">" + entry.getKey() + "</td>");
            sb.append("<td>" + entry.getValue() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("<br/>");

        sb.append("<table class=\"center\">");
        sb.append("<tr class=\"tr1st\">");
        sb.append("<td class=\"left\"><H3>Liczba wyborów użytkownika w drugim przedziale czasu</H3>");
        sb.append("<p>(dni:30, godziny:0, minuty:0, sekundy:0)</p></td>");
        sb.append("<td><H3>" + statistics.getNumberOfVisits(last2, now) + "</H3></td>");
        sb.append("</tr>");
        numberOfVisitsEachName = statistics.getOccurrenceMap(last2, now);
        entries = numberOfVisitsEachName.entrySet();
        for(Entry<String, Integer> entry : entries){
            sb.append("<tr>");
            sb.append("<td class=\"left\">" + entry.getKey() + "</td>");
            sb.append("<td>" + entry.getValue() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("<br/>");

        String message = sb.toString();




        EmailService email = new EmailService(timerConfiguration.getEmailLogin(), timerConfiguration.getEmailPass(), timerConfiguration.getEmailSmtpAdress(), timerConfiguration.getEmailPort());
        logger.log(Level.INFO, "udalo sie!");
        boolean response = timerInfo.getInfo();
        logger.log(Level.INFO, "response=" + response);
        if (response) {
            try {
                email.send(timerConfiguration.getTargetEmail(), "Scheduled report", message);
                logger.log(Level.INFO, "email has been sent");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }


}

