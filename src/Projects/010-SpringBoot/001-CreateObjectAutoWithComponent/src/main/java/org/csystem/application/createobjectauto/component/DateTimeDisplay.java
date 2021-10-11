package org.csystem.application.createobjectauto.component;

import org.csystem.util.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeDisplay {
    public DateTimeDisplay()
    {
        Console.writeLine("DateTimeDisplay.DateTimeDisplay()");
    }

    @PostConstruct
    public void displayDateTime()
    {
        var now = LocalDateTime.now();
        var nowText = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(now);

        Console.writeLine("DateTimeDisplay:%s", nowText);
    }
}
