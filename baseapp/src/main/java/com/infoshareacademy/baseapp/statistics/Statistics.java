package com.infoshareacademy.baseapp.statistics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static Statistics statistics = new Statistics();

    private Statistics() {
    }

    public static Statistics getInstance() {
        return statistics;
    }

    private List<Record> recordsList = new ArrayList<>();

    public void add(Record record) {
        recordsList.add(record);
    }

    public List<Record> getAll() {
        return recordsList;
    }

    public List<Record> getAll(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Record> result = new ArrayList<>();
        for (Record record : recordsList) {
            if ((record.getDateTime().isAfter(dateFrom) || record.getDateTime().isEqual(dateFrom)) && (record.getDateTime().isBefore(dateTo) || record.getDateTime().isEqual(dateTo))) {
                result.add(record);
            }
        }
        return result;
    }

    public List<RecordStringDate> getAllFormatted() {
        List<Record> list = getAll();
        List<RecordStringDate> result = new ArrayList<>();
        for (Record record : list){
            String date = record.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
            RecordStringDate recordStringDate = new RecordStringDate(record.getName(),date);
            result.add(recordStringDate);
        }
        return result;
    }

    public boolean contain(Record record) {
        return recordsList.contains(record);
    }

    public boolean isEmpty() {
        return recordsList.isEmpty();
    }

    public void clear() {
        recordsList.clear();
    }

    public Integer getNumberOfVisits() {
        return recordsList.size();
    }

    public Integer getNumberOfVisits(String name) {
        Integer counter = 0;
        for (Record record : recordsList) {
            if (record.getName().equals(name)) {
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfVisits(LocalDateTime dateFrom, LocalDateTime dateTo) {
        Integer counter = 0;
        for (Record record : recordsList) {
            if ((record.getDateTime().isAfter(dateFrom) || record.getDateTime().isEqual(dateFrom)) && (record.getDateTime().isBefore(dateTo) || record.getDateTime().isEqual(dateTo))) {
                counter++;
            }
        }
        return counter;
    }

    public Integer getNumberOfVisits(String name, LocalDateTime dateFrom, LocalDateTime dateTo) {
        Integer counter = 0;
        for (Record record : recordsList) {
            if (record.getName().equals(name) && (record.getDateTime().isAfter(dateFrom) || record.getDateTime().isEqual(dateFrom)) && (record.getDateTime().isBefore(dateTo) || record.getDateTime().isEqual(dateTo))) {
                counter++;
            }
        }
        return counter;
    }

    public Map<String, Integer> getOccurrenceMap() {

        Map<String, Integer> numberOfVisitsEachName = new HashMap<>();
        for (Record record : recordsList) {
            if (numberOfVisitsEachName.containsKey(record.getName())) {
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName()) + 1);
            } else {
                numberOfVisitsEachName.put(record.getName(), 1);
            }
        }
        return numberOfVisitsEachName;
    }

    public Map<String, Integer> getOccurrenceMap(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Record> recordsListFilteredByDateRange = getAll(dateFrom, dateTo);
        Map<String, Integer> numberOfVisitsEachName = new HashMap<>();
        for (Record record : recordsListFilteredByDateRange) {
            if (numberOfVisitsEachName.containsKey(record.getName())) {
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName()) + 1);
            } else {
                numberOfVisitsEachName.put(record.getName(), 1);
            }
        }
        return numberOfVisitsEachName;
    }
}
