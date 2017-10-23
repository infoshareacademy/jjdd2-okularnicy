package com.infoshareacademy.baseapp.report;

import com.infoshareacademy.baseapp.statistics.Record;
import com.infoshareacademy.baseapp.statistics.Statistics;
import com.sun.org.apache.regexp.internal.RE;

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

        sb.append("=======================" + "\n");
        sb.append("== DANE STATYSTYCZNE ==" + "\n");
        sb.append("=======================" + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsAgo = now.minusSeconds(10);
        LocalDateTime twentySecondsAgo = now.minusSeconds(20);

        sb.append("Calkowita liczba wyborow: " + statistics.getNumberOfVisits() + "\n");
        List<Record> recordsList = statistics.getAll();
        Map<String, Integer> numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("w ciagu ostatnich 10 sekund: " + statistics.getNumberOfVisits(tenSecondsAgo, now) + "\n");
        recordsList = statistics.getAll(tenSecondsAgo, now);
        numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("w ciagu ostatnich 20 sekund: " + statistics.getNumberOfVisits(twentySecondsAgo, now) + "\n");
        recordsList = statistics.getAll(twentySecondsAgo, now);
        numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("Historia" + "\n");
        recordsList = statistics.getAll();
        for(Record record: recordsList){
            sb.append(record.getName() + ">>" + record.getDateTime() + "\n");
        }
        sb.append("" + "\n");
        sb.append("" + "\n");

        return sb.toString();
    }



}
