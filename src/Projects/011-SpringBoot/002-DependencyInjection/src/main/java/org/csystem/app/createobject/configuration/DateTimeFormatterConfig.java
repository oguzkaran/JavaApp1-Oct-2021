package org.csystem.app.createobject.configuration;

import org.csystem.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean("org.csystem.datetime.datetimeformatter")
    public DateTimeFormatter createDateTimeFormatter()
    {
        Console.writeLine("----------------------------------");
        Console.writeLine("DateTimeConfig.createDateTimeFormatter");
        Console.writeLine("----------------------------------");

        return DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
    }

    @Bean("org.csystem.datetime.timeformatter")
    public DateTimeFormatter createTimeFormatter()
    {
        Console.writeLine("----------------------------------");
        Console.writeLine("DateTimeConfig.createTimeFormatter");
        Console.writeLine("----------------------------------");

        return DateTimeFormatter.ofPattern("hh:mm:ss");
    }
}
