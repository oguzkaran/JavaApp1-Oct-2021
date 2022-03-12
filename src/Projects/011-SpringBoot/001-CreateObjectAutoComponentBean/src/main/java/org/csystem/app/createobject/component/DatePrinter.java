package org.csystem.app.createobject.component;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DatePrinter {
    public DatePrinter()
    {
        Console.writeLine("DatePrinter.DatePrinter()");
    }

    @PostConstruct
    public void printDateTime()
    {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Console.writeLine("Today:%s", formatter.format(LocalDate.now()));
    }
}
