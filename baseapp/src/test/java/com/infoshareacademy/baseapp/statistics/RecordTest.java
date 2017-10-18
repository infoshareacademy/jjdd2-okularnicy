package com.infoshareacademy.baseapp.statistics;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class RecordTest {

    @Test
    public void checkRecordCreation() throws Exception {
        // given
        LocalDateTime now = LocalDateTime.now();
        String name = "Fundusz inwestycyjny";
        // when
        Record sut = new Record(name, now);
        // then
        assertThat(sut.getName()).isEqualTo(name);
        assertThat(sut.getDateTime()).isEqualTo(now);
    }
}