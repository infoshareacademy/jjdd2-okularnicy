package com.infoshareacademy.baseapp.statistics;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class StatisticsTest {

    @Test
    public void checkRecordInsertion() throws Exception {
        // given
        Statistics statistics = new Statistics();
        Record record = new Record("sampleName", LocalDateTime.of(2017,10,18,15,00));
        // when
        assertThat(statistics.contain(record)).isEqualTo(false);
        statistics.add(record);
        // then
        assertThat(statistics.contain(record)).isEqualTo(true);
    }
    
    @Test
    public void checkClearStatistics() throws Exception {
        // given
        Statistics statistics = new Statistics();
        Record record = new Record("sampleName", LocalDateTime.of(2017,10,18,15,00));
        assertThat(statistics.isEmpty()).isEqualTo(true);
        assertThat(statistics.getAll()).isEmpty();
        statistics.add(record);
        assertThat(statistics.isEmpty()).isEqualTo(false);
        assertThat(statistics.getAll()).isNotEmpty();
        // when
        statistics.clear();
        // then
        assertThat(statistics.isEmpty()).isEqualTo(true);
        assertThat(statistics.getAll()).isEmpty();
    }

    @Test
    public void checkTotalNumberOfEveryVisits() throws Exception {
        // given
        Statistics statistics = new Statistics();
        Record record1 = new Record("name1", LocalDateTime.of(2015,10,18,15,00));
        Record record2 = new Record("name2", LocalDateTime.of(2016,10,18,15,00));
        Record record3 = new Record("name3", LocalDateTime.of(2017,10,18,15,00));
        // when
        statistics.add(record1);
        statistics.add(record2);
        statistics.add(record3);
        // then
        assertThat(statistics.getNumberOfVisits()).isEqualTo(3);
    }

    @Test
    public void checkTotalNumberOfVisitsGivenName() throws Exception {
        // given
        Statistics statistics = new Statistics();
        String name1 = "name1";
        String name2 = "name2";
        Record record1 = new Record(name1, LocalDateTime.of(2015,10,18,15,00));
        Record record2 = new Record(name1, LocalDateTime.of(2016,10,18,15,00));
        Record record3 = new Record(name1, LocalDateTime.of(2017,10,18,15,00));
        Record record4 = new Record(name2, LocalDateTime.of(2017,10,18,15,00));//other name
        // when
        statistics.add(record1);
        statistics.add(record2);
        statistics.add(record3);
        statistics.add(record4);//other name
        // then
        assertThat(statistics.getNumberOfVisits(name1)).isEqualTo(3);
    }

    @Test
    public void checkTotalNumberOfVisitsInGivenDateRange() throws Exception {
        // given
        Statistics statistics = new Statistics();
        String name = "name1";
        LocalDateTime dateBefore =      LocalDateTime.of(2017,10,17,13,59);
        LocalDateTime dateFrom =        LocalDateTime.of(2017,10,17,14,00);
        LocalDateTime dateInTheMiddle = LocalDateTime.of(2017,10,18,10,00);
        LocalDateTime dateTo =          LocalDateTime.of(2017,10,18,15,00);
        LocalDateTime dateAfter =       LocalDateTime.of(2017,10,18,15,01);
        Record properRecord1 = new Record(name, dateFrom);
        Record properRecord2 = new Record(name, dateInTheMiddle);
        Record properRecord3 = new Record(name, dateTo);
        Record improperRecord1 = new Record(name, dateBefore);
        Record improperRecord2 = new Record(name, dateAfter);
        // when
        statistics.add(properRecord1);
        statistics.add(properRecord2);
        statistics.add(properRecord3);
        statistics.add(improperRecord1);
        statistics.add(improperRecord2);
        // then
        assertThat(statistics.getNumberOfVisits(dateFrom, dateTo)).isEqualTo(3);
    }

    @Test
    public void checkTotalNumberOfVisitsGivenNameInGivenDateRange() throws Exception {
        // given
        Statistics statistics = new Statistics();
        String properName = "name1";
        String improperName = "name2";
        LocalDateTime dateBefore =      LocalDateTime.of(2017,10,17,13,59);
        LocalDateTime dateFrom =        LocalDateTime.of(2017,10,17,14,00);
        LocalDateTime dateInTheMiddle = LocalDateTime.of(2017,10,18,10,00);
        LocalDateTime dateTo =          LocalDateTime.of(2017,10,18,15,00);
        LocalDateTime dateAfter =       LocalDateTime.of(2017,10,18,15,01);
        Record properRecord1 = new Record(properName, dateFrom);
        Record properRecord2 = new Record(properName, dateInTheMiddle);
        Record properRecord3 = new Record(properName, dateTo);
        Record improperRecord1 = new Record(improperName, dateFrom);
        Record improperRecord2 = new Record(improperName, dateInTheMiddle);
        Record improperRecord3 = new Record(improperName, dateTo);
        Record improperRecord4 = new Record(properName, dateBefore);
        Record improperRecord5 = new Record(properName, dateAfter);
        Record improperRecord6 = new Record(improperName, dateAfter);
        Record improperRecord7 = new Record(improperName, dateAfter);
        // when
        statistics.add(properRecord1);
        statistics.add(properRecord2);
        statistics.add(properRecord3);
        statistics.add(improperRecord1);
        statistics.add(improperRecord2);
        statistics.add(improperRecord3);
        statistics.add(improperRecord4);
        statistics.add(improperRecord5);
        statistics.add(improperRecord6);
        statistics.add(improperRecord7);
        // then
        assertThat(statistics.getNumberOfVisits(properName, dateFrom, dateTo)).isEqualTo(3);
    }
}