package org.csystem.util.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class BirthDateInfo {
    private static final double ms_dividerForAge = 1000. * 60 * 60 * 24 * 365;
    private final LocalDate m_birthDate;

    public BirthDateInfo(int day, int month, int year)
    {
        //...
        m_birthDate = LocalDate.of(year, month, day);
    }

    public int getYear()
    {
        return m_birthDate.getYear();
    }

    public int getMonthValue()
    {
        return m_birthDate.getMonthValue();
    }

    public Month getMonth()
    {
        return m_birthDate.getMonth();
    }

    public int getDayOfMonth()
    {
        return m_birthDate.getDayOfMonth();
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    public BirthDateStatus getBirtDateStatus()
    {
        var today = LocalDate.now();
        var birthDay = m_birthDate.withYear(today.getYear());
        BirthDateStatus status = BirthDateStatus.SAME;

        if (birthDay.isAfter(today))
            status = BirthDateStatus.AFTER;
        else if (birthDay.isBefore(today))
            status = BirthDateStatus.BEFORE;

        return status;
    }

    //...
}
