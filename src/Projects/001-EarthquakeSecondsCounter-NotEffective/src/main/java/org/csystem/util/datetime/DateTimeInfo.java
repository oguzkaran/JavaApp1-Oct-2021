package org.csystem.util.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public final class DateTimeInfo {
    private final LocalDateTime m_dateTime;

    public DateTimeInfo(LocalDate date, LocalTime time)
    {
        m_dateTime = date.atTime(time);
    }

    public DateTimeInfo(int day, Month month, int year, int hour, int minute, int second)
    {
        m_dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
    }

    public LocalDateTime getDateTime()
    {
        return m_dateTime;
    }

    public long getSeconds()
    {
        return ChronoUnit.SECONDS.between(m_dateTime, LocalDateTime.now());
    }

    public long getDays()
    {
        return ChronoUnit.DAYS.between(m_dateTime, LocalDateTime.now());
    }

    public long getMonths()
    {
        return ChronoUnit.MONTHS.between(m_dateTime, LocalDateTime.now());
    }

    public long getYears()
    {
        return ChronoUnit.YEARS.between(m_dateTime, LocalDateTime.now());
    }

    public double getActualYear()
    {
        return getDays() / 365.;
    }
}
