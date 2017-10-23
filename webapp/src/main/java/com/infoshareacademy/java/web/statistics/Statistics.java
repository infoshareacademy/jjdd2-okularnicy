package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.java.web.entities.Stats;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private static Statistics statistics = new Statistics();

    private Statistics(){
    }

    public static Statistics getInstance(){
        return statistics;
    }

    private List<Stats> statsList = new ArrayList<>();

    public void add(Stats stats) {
        statsList.add(stats);
    }

    public List<Stats> getAll() {
        return statsList;
    }

    public List<Stats> getAll(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Stats> result = new ArrayList<>();
        for(Stats stats : statsList){
            if ((stats.getStatsTime().isAfter(dateFrom) || stats.getStatsTime().isEqual(dateFrom)) && (stats.getStatsTime().isBefore(dateTo) || stats.getStatsTime().isEqual(dateTo))){
                result.add(stats);
            }
        }
        return result;
    }

    public boolean contain(Stats stats) {
        return statsList.contains(stats);
    }

    public boolean isEmpty() {
        return statsList.isEmpty();
    }

    public void clear() {
        statsList.clear();
    }

    public Integer getNumberOfVisits() {
        return statsList.size();
    }

    public Integer getNumberOfVisits(String name) {
        Integer counter = 0;
        for(Stats stats: statsList){
            if (stats.getStatsName().equals(name)){
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfVisits(LocalDateTime dateFrom, LocalDateTime dateTo) {
        Integer counter = 0;
        for(Stats stats: statsList){
            if ((stats.getStatsTime().isAfter(dateFrom) || stats.getStatsTime().isEqual(dateFrom)) && (stats.getStatsTime().isBefore(dateTo) || stats.getStatsTime().isEqual(dateTo))){
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfVisits(String name, LocalDateTime dateFrom, LocalDateTime dateTo) {
        Integer counter = 0;
        for(Stats stats: statsList){
            if (stats.getStatsName().equals(name) && (stats.getStatsTime().isAfter(dateFrom) || stats.getStatsTime().isEqual(dateFrom)) && (stats.getStatsTime().isBefore(dateTo) || stats.getStatsTime().isEqual(dateTo))){
            counter++;
            }
        }
        return counter;
    }
}
