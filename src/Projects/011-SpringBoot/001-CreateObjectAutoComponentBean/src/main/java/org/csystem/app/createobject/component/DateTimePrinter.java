package org.csystem.app.createobject.component;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimePrinter {
    public DateTimePrinter()
    {
        Console.writeLine("DateTimePrinter.DateTimePrinter()");
    }

    @PostConstruct
    public void printDateTime()
    {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        Console.writeLine("Now:%s", formatter.format(LocalDateTime.now()));
    }
}
