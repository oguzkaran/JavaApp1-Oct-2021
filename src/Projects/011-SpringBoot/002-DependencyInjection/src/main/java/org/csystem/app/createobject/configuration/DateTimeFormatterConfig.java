package org.csystem.app.createobject.configuration;

import org.csystem.util.console.Console;
import org.csystem.util.datetime.DateTimeFormatterUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean("org.csystem.datetime.datetimeformatter")
    public DateTimeFormatter getDateTimeFormatter()
    {
        Console.writeLine("----------------------------------");
        Console.writeLine("DateTimeConfig.createDateTimeFormatter");
        Console.writeLine("----------------------------------");

        return DateTimeFormatterUtil.DATETIME_SEC_TR;
    }

    @Bean("org.csystem.datetime.timeformatter")
    public DateTimeFormatter getTimeFormatter()
    {
        Console.writeLine("----------------------------------");
        Console.writeLine("DateTimeConfig.createTimeFormatter");
        Console.writeLine("----------------------------------");

        return DateTimeFormatterUtil.TIME_SEC;
    }
}
