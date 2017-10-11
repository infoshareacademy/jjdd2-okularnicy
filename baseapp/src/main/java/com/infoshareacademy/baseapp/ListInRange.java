package com.infoshareacademy.baseapp;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListInRange {

    private final Program program;

    public ListInRange(Program program) {
        this.program = program;
    }

    public List<Fund> setListInRange () {
        LocalDate startDate = program.getStartDate();
        LocalDate endDate = program.getEndDate();
        List<Fund> listInRange = program.getFundsList().stream()
                .filter(o -> o.getDate().isAfter(startDate) || o.getDate().isEqual(startDate))
                .filter(o -> o.getDate().isBefore(endDate) || o.getDate().isEqual(endDate))
                .collect(Collectors.toList());
        return listInRange;
    }
}