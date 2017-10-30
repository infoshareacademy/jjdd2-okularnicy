package com.infoshareacademy.baseapp.statistics;

import org.junit.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class DurationTransformationServiceTest {

    DurationTransformationService sut = new DurationTransformationService();

    @Test
    public void checkDurationToDaysHoursMinutesSeconds() throws Exception {
        // given
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        DaysHoursMinutesSeconds expectedDaysHoursMinutesSeconds1 = new DaysHoursMinutesSeconds(1l,1l,1l,1l);
        DaysHoursMinutesSeconds expectedDaysHoursMinutesSeconds2 = new DaysHoursMinutesSeconds(5l,6l,7l,8l);
        // when
        DaysHoursMinutesSeconds result1 = sut.getDaysHoursMinutesSeconds(duration1);
        DaysHoursMinutesSeconds result2 = sut.getDaysHoursMinutesSeconds(duration2);
        // then
        assertThat(result1).isEqualTo(expectedDaysHoursMinutesSeconds1);
        assertThat(result2).isEqualTo(expectedDaysHoursMinutesSeconds2);
    }

    @Test
    public void checkDurationToDays() throws Exception {
        // given
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getDays(duration1);
        Long result2 = sut.getDays(duration2);
        // then
        assertThat(result1).isEqualTo(1l);
        assertThat(result2).isEqualTo(5l);
    }

    @Test
    public void checkDurationToHours() throws Exception {
        // given
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getHours(duration1);
        Long result2 = sut.getHours(duration2);
        // then
        assertThat(result1).isEqualTo(1l);
        assertThat(result2).isEqualTo(6l);
    }

    @Test
    public void checkDurationToMinutes() throws Exception {
        // given
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getMinutes(duration1);
        Long result2 = sut.getMinutes(duration2);
        // then
        assertThat(result1).isEqualTo(1l);
        assertThat(result2).isEqualTo(7l);
    }

    @Test
    public void checkDurationToSeconds() throws Exception {
        // given
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getSeconds(duration1);
        Long result2 = sut.getSeconds(duration2);
        // then
        assertThat(result1).isEqualTo(1l);
        assertThat(result2).isEqualTo(8l);
    }
}