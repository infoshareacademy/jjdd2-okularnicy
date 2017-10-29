package com.infoshareacademy.baseapp.statistics;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DaysHoursMinutesSecondsTest {

    @Test
    public void checkValuesCreation() throws Exception {
        // given
        DaysHoursMinutesSeconds sut;
        // when
        sut = new DaysHoursMinutesSeconds(10l,11l,12l,13l);
        // then
        assertThat(sut.getDays()).isEqualTo(10);
        assertThat(sut.getHours()).isEqualTo(11);
        assertThat(sut.getMinutes()).isEqualTo(12);
        assertThat(sut.getSecods()).isEqualTo(13);
    }

    @Test
    public void checkEqual() throws Exception {
        // given
        DaysHoursMinutesSeconds object1 = new DaysHoursMinutesSeconds(10l,11l,12l,13l);
        DaysHoursMinutesSeconds object2 = new DaysHoursMinutesSeconds(10l,11l,12l,13l);
        // when
        boolean result = object1.equals(object2);
        // then
        assertThat(result).isTrue();

    }
}