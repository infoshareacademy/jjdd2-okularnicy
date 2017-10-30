package com.infoshareacademy.baseapp.statistics;

import java.time.Duration;

public class DurationTransformationService {
    public Long getDays(Duration duration) {
        return duration.toDays();
    }

    public Long getHours(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        return duration.toHours();
    }

    public Long getMinutes(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        Long hours = duration.toHours();
        duration = duration.minusHours(hours);
        return duration.toMinutes();
    }

    public Long getSeconds(Duration duration) {
        Long days = duration.toDays();
        duration = duration.minusDays(days);
        Long hours = duration.toHours();
        duration = duration.minusHours(hours);
        Long minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        return duration.getSeconds();
    }
}
