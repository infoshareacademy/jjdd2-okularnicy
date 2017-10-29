package com.infoshareacademy.baseapp.statistics;

import java.time.Duration;

public class DurationTransformation {
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
}
