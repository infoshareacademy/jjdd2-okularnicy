package com.infoshareacademy.java.web.report;



import com.infoshareacademy.java.web.entities.Stats;
import com.infoshareacademy.java.web.statistics.Statistics;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

    private static Report report = new Report();

    private Report(){
    }

    public static Report getInstance(){
        return report;
    }

    public String generateReport(){
        Statistics statistics = Statistics.getInstance();
        StringBuilder sb = new StringBuilder();

        sb.append("jestes w statystykach" + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsAgo = now.minusSeconds(10);
        LocalDateTime twentySecondsAgo = now.minusSeconds(20);

        sb.append("Calkowita liczba wyborow: " + statistics.getNumberOfVisits() + "\n");
        List<Stats> recordsList = statistics.getAll();
        Map<String, Integer> numberOfVisitsEachName = new HashMap<>();
        for(Stats stats: recordsList){
            if ( numberOfVisitsEachName.containsKey(stats.getStatsName()) ){
                numberOfVisitsEachName.put(stats.getStatsName(), numberOfVisitsEachName.get(stats.getStatsName())+1);
            } else {
                numberOfVisitsEachName.put(stats.getStatsName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("w ciagu ostatnich 10 sekund: " + statistics.getNumberOfVisits(tenSecondsAgo, now) + "\n");
        recordsList = statistics.getAll(tenSecondsAgo, now);
        numberOfVisitsEachName = new HashMap<>();
        for(Stats stats: recordsList){
            if ( numberOfVisitsEachName.containsKey(stats.getStatsName()) ){
                numberOfVisitsEachName.put(stats.getStatsName(), numberOfVisitsEachName.get(stats.getStatsName())+1);
            } else {
                numberOfVisitsEachName.put(stats.getStatsName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("w ciagu ostatnich 20 sekund: " + statistics.getNumberOfVisits(twentySecondsAgo, now) + "\n");
        recordsList = statistics.getAll(twentySecondsAgo, now);
        numberOfVisitsEachName = new HashMap<>();
        for(Stats stats: recordsList){
            if ( numberOfVisitsEachName.containsKey(stats.getStatsName()) ){
                numberOfVisitsEachName.put(stats.getStatsName(), numberOfVisitsEachName.get(stats.getStatsName())+1);
            } else {
                numberOfVisitsEachName.put(stats.getStatsName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("Historia" + "\n");
        recordsList = statistics.getAll();
        for(Stats stats: recordsList){
            sb.append(stats.getStatsName() + ">>" + stats.getStatsTime() + "\n");
        }
        sb.append("" + "\n");
        sb.append("" + "\n");

        return sb.toString();
    }



}
