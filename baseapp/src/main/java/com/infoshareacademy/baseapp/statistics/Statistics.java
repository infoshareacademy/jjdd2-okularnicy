package com.infoshareacademy.baseapp.statistics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private List<Record> recordsList = new ArrayList<>();

    public void add(Record record) {
        recordsList.add(record);
    }

    public boolean contain(Record record) {
        return recordsList.contains(record);
    }

    public void clear() {
        recordsList.clear();
    }

    public boolean isEmpty() {
        return recordsList.isEmpty();
    }

    public List<Record> getAll() {
        return recordsList;
    }

    public Integer getNumberOfVisits(String name) {
        Integer counter = 0;
        for(Record record : recordsList){
            if (record.getName().equals(name)){
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfVisits() {
        return recordsList.size();
    }

    public Integer getNumberOfVisits(String name, LocalDateTime dateFrom, LocalDateTime dateTo) {
        Integer counter = 0;
        for(Record record : recordsList){
            if (record.getName().equals(name) && (record.getDateTime().isAfter(dateFrom) || record.getDateTime().isEqual(dateFrom)) && (record.getDateTime().isBefore(dateTo) || record.getDateTime().isEqual(dateTo))){
            counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfVisits(LocalDateTime dateFrom, LocalDateTime dateTo) {
        Integer counter = 0;
        for(Record record : recordsList){
            if ((record.getDateTime().isAfter(dateFrom) || record.getDateTime().isEqual(dateFrom)) && (record.getDateTime().isBefore(dateTo) || record.getDateTime().isEqual(dateTo))){
                counter++;
            }
        }
        return counter;
    }
}
