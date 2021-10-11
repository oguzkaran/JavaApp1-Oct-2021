package org.csystem.application.createobjectauto.component;

import org.csystem.util.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateAndTimeDisplay {
    public DateAndTimeDisplay()
    {
        Console.writeLine("DateAndTimeDisplay.DateAndTimeDisplay()");
    }

    @PostConstruct
    public void displayTime()
    {
        var now = LocalTime.now();
        var nowText = DateTimeFormatter.ofPattern("hh:mm::ss").format(now);

        Console.writeLine("DateAndTimeDisplay:%s", nowText);
    }

    @PostConstruct
    public void displayDate()
    {
        var today = LocalDate.now();
        var todayText = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(today);

        Console.writeLine("DateAndTimeDisplay:%s", todayText);
    }
}
