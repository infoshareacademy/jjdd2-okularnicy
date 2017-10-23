package com.infoshareacademy.baseapp.statistics;

import java.time.LocalDateTime;

public class Record_toDelete {
    private String name;
    private LocalDateTime dateTime;

    public Record_toDelete(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
