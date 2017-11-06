package com.infoshareacademy.baseapp.statistics;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class Report {
    private Statistics statistics = Statistics.getInstance();

    public String getReport(){
        Duration durationOfFirstPeriodOfTime;
        Duration durationOfSecondPeriodOfTime;
        durationOfFirstPeriodOfTime = Duration.ofDays(7);
        durationOfSecondPeriodOfTime = Duration.ofDays(30);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime last1 = now.minus(durationOfFirstPeriodOfTime);
        LocalDateTime last2 = now.minus(durationOfSecondPeriodOfTime);

        StringBuilder sb = new StringBuilder();

        sb.append("<H1>STATYSTYKI</H1>");

        sb.append("<table class=\"center\">");
        sb.append("<tr class=\"tr1st\">");
        sb.append("<td class=\"left\"><H3>Liczba wyborów użytkownika w pierwszym przedziale czasu</H3>");
        sb.append("<p>(dni:7, godziny:0, minuty:0, sekundy:0)</p></td>");
        sb.append("<td><H3>" + statistics.getNumberOfVisits(last1, now) + "</H3></td>");
        sb.append("</tr>");
        Map<String, Integer> numberOfVisitsEachName = statistics.getOccurrenceMap(last1, now);
        Set<Map.Entry<String, Integer>> entries = numberOfVisitsEachName.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
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
        for(Map.Entry<String, Integer> entry : entries){
            sb.append("<tr>");
            sb.append("<td class=\"left\">" + entry.getKey() + "</td>");
            sb.append("<td>" + entry.getValue() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("<br/>");

        String message = sb.toString();
        return message;
    }
}
