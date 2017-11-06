package com.infoshareacademy.baseapp.statistics;

public class RecordStringDate {
    private String name;
    private String dateTime;

    public RecordStringDate(String name, String dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
