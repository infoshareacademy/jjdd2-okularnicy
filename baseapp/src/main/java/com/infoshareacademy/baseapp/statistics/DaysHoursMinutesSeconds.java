package com.infoshareacademy.baseapp.statistics;

public class DaysHoursMinutesSeconds {
    private Long Days;
    private Long Hours;
    private Long Minutes;
    private Long Secods;

    public DaysHoursMinutesSeconds(Long days, Long hours, Long minutes, Long secods) {
        Days = days;
        Hours = hours;
        Minutes = minutes;
        Secods = secods;
    }

    public Long getDays() {
        return Days;
    }

    public void setDays(Long days) {
        Days = days;
    }

    public Long getHours() {
        return Hours;
    }

    public void setHours(Long hours) {
        Hours = hours;
    }

    public Long getMinutes() {
        return Minutes;
    }

    public void setMinutes(Long minutes) {
        Minutes = minutes;
    }

    public Long getSecods() {
        return Secods;
    }

    public void setSecods(Long secods) {
        Secods = secods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DaysHoursMinutesSeconds that = (DaysHoursMinutesSeconds) o;

        if (Days != null ? !Days.equals(that.Days) : that.Days != null) return false;
        if (Hours != null ? !Hours.equals(that.Hours) : that.Hours != null) return false;
        if (Minutes != null ? !Minutes.equals(that.Minutes) : that.Minutes != null) return false;
        return Secods != null ? Secods.equals(that.Secods) : that.Secods == null;
    }

    @Override
    public int hashCode() {
        int result = Days != null ? Days.hashCode() : 0;
        result = 31 * result + (Hours != null ? Hours.hashCode() : 0);
        result = 31 * result + (Minutes != null ? Minutes.hashCode() : 0);
        result = 31 * result + (Secods != null ? Secods.hashCode() : 0);
        return result;
    }
}
