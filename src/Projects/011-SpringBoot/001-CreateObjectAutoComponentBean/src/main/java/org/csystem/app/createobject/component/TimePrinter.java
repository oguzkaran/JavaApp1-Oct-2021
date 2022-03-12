package org.csystem.app.createobject.component;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimePrinter {
    public TimePrinter()
    {
        Console.writeLine("TimePrinter.TimePrinter()");
    }

    @PostConstruct
    public void printDateTime()
    {
        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        Console.writeLine("Now:%s", formatter.format(LocalTime.now()));
    }
}
