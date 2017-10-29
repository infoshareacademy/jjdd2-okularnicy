package com.infoshareacademy.baseapp.statistics;

import org.junit.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class DurationTransformationTest {

    DurationTransformation sut = new DurationTransformation();

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
    public void test() throws Exception {
        // given
        String test1 = "abc";
        String test2 = "abc";
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        DaysHoursMinutesSeconds daysHoursMinutesSeconds = sut.getDaysHoursMinutesSeconds(duration1);
        // when

        // then
        assertThat(test1).isEqualTo(test2);

    }
}