package com.infoshareacademy.baseapp.statistics;

import java.time.Duration;

public class DurationTransformationService {
    public DaysHoursMinutesSeconds getDaysHoursMinutesSeconds(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        Long hours = duration.toHours();
        duration = duration.minusHours(hours);
        Long minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        Long seconds = duration.getSeconds();
        return new DaysHoursMinutesSeconds(days, hours, minutes, seconds);
    }

    public Long getDays(Duration duration) {
        Long days = duration.toDays();
        return days;
    }

    public Long getHours(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        Long hours = duration.toHours();
        return hours;
    }

    public Long getMinutes(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        Long hours = duration.toHours();
        duration = duration.minusHours(hours);
        Long minutes = duration.toMinutes();
        return minutes;
    }

    public Long getSeconds(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        Long hours = duration.toHours();
        duration = duration.minusHours(hours);
        Long minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        Long seconds = duration.getSeconds();
        return seconds;
    }
}
