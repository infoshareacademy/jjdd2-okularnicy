package com.infoshareacademy.baseapp.statistics;

import org.junit.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class DurationTransformationServiceTest {

    DurationTransformationService sut = new DurationTransformationService();

    @Test
    public void checkDurationToDays() throws Exception {
        // given
        Long expectedDays1 = 1l;
        Long expectedDays2 = 5l;
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getDays(duration1);
        Long result2 = sut.getDays(duration2);
        // then
        assertThat(result1).isEqualTo(expectedDays1);
        assertThat(result2).isEqualTo(expectedDays2);
    }

    @Test
    public void checkDurationToHours() throws Exception {
        // given
        Long expectedHours1 = 1l;
        Long expectedHours2 = 6l;
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getHours(duration1);
        Long result2 = sut.getHours(duration2);
        // then
        assertThat(result1).isEqualTo(expectedHours1);
        assertThat(result2).isEqualTo(expectedHours2);
    }

    @Test
    public void checkDurationToMinutes() throws Exception {
        // given
        Long expectedMinutes1 = 1l;
        Long expectedMinutes2 = 7l;
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getMinutes(duration1);
        Long result2 = sut.getMinutes(duration2);
        // then
        assertThat(result1).isEqualTo(expectedMinutes1);
        assertThat(result2).isEqualTo(expectedMinutes2);
    }

    @Test
    public void checkDurationToSeconds() throws Exception {
        // given
        Long expectedSeconds1 = 1l;
        Long expectedSeconds2 = 8l;
        Duration duration1 = Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        Duration duration2 = Duration.ofDays(5).plusHours(6).plusMinutes(7).plusSeconds(8);
        // when
        Long result1 = sut.getSeconds(duration1);
        Long result2 = sut.getSeconds(duration2);
        // then
        assertThat(result1).isEqualTo(expectedSeconds1);
        assertThat(result2).isEqualTo(expectedSeconds2);
    }
}