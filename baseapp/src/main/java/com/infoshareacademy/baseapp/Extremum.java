package com.infoshareacademy.baseapp;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Extremum {

    private Fund max;
    private Fund min;
    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    public void setMax(Fund max) {
        this.max = max;
    }

    public void setMin(Fund min) {
        this.min = min;
    }

    public Fund findMin(List<Fund> listToSortAsc) {
        Collections.sort(listToSortAsc, new MyAscComparator());
        setMin(listToSortAsc.get(0));
        logger.log(Level.INFO, "Wybrano wartość minimalną:" + min);
        return min;
    }

    public Fund findMax(List<Fund> listToSortDesc) {
        Collections.sort(listToSortDesc, new MyDescComparator());
        setMax(listToSortDesc.get(0));
        logger.log(Level.INFO, "Wybrano wartość maksymalna:" + max);
        return max;
    }
}