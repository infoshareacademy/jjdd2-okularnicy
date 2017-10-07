package com.infoshareacademy.baseapp;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListInRange {

    private final Program program;

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    public ListInRange(Program program) {
        this.program = program;
    }

    public void isDateIsInRange() {
        LocalDate startDate = program.getStartDate();
        LocalDate endDate = program.getEndDate();
        Fund firstFund = program.getFundsList().get(0);
        Fund lastFund = program.getFundsList().get(program.getFundsList().size()-1);

        if (startDate.isBefore(firstFund.getDate()) || endDate.isAfter(lastFund.getDate())) {
            System.out.println("Podany zakres wykracza poza dostępne dane.");
            logger.log(Level.WARN, "Podany zakres wykracza poza dostępne dane." + "(" + startDate + " - " + endDate + ")");
        } else if (startDate.isBefore(firstFund.getDate()) && endDate.isBefore(firstFund.getDate()) ||
                startDate.isAfter(lastFund.getDate()) && endDate.isBefore(lastFund.getDate())) {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie.");
            logger.log(Level.WARN, "Brak danych dla podanego przedziału czasu. Spróbuj ponownie." + "(" + startDate + " - " + endDate + ")");
        } else {
            System.out.println("Wczytano poprawnie dane z podanego zakresu.");
            logger.log(Level.INFO, "Wczytano poprawnie dane z podanego zakresu.");
        }
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