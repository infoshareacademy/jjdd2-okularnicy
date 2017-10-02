package com.infoshareacademy.baseapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Program {

    private Map<String, String> fundsMap;
    private String pathToFile;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Fund> fundsList = new ArrayList<>();
    private Extremum extremum = new Extremum();


    public Program() {
        fundsMap = new HashMap<>();
    }

    public Map<String, String> getFundsMap() {
        return fundsMap;
    }

    public void setFundsMap(Map<String, String> fundsMap) {
        this.fundsMap = fundsMap;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = "testdata/" + pathToFile;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Fund> getFundsList() {
        return fundsList;
    }

    public void setFundsList(ArrayList<Fund> fundsList) {
        this.fundsList = fundsList;
    }

    public Extremum getExtremum() {
        return extremum;
    }
}

