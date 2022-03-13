package org.csystem.app.createobject.configuration;

import org.csystem.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

@Configuration
public class DateTimeConfig {
    @Bean("dateTimeConfigCreateNow")
    @Scope("prototype")
    public Temporal getNow()
    {
        Console.writeLine("----------------------------------");
        Console.writeLine("DateTimeConfig.createNow");
        Console.writeLine("----------------------------------");

        return LocalDateTime.now();
    }
}
