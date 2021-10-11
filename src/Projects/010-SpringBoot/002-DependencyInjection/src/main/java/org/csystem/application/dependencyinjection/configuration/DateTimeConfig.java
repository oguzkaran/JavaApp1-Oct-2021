package org.csystem.application.dependencyinjection.configuration;

import org.csystem.util.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@Configuration
public class DateTimeConfig {
    @Bean //Bean isminin verilmezse metot ismi ile aynı olduğunu göstermek için bean'e isim verilmedi. Normal olarak verilmesi daha uygun olabilir
    public Temporal getBirthDateTemporal()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("DateTimeConfig.getBirthDateTemporal");
        Console.writeLine("--------------------------------------------------------------");
        return LocalDate.of(1976, 9, 10);
    }

    @Bean("today")
    @Scope("prototype")
    public Temporal createToday()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("DateTimeConfig.createToday");
        Console.writeLine("--------------------------------------------------------------");
        return LocalDate.now();
    }

    @Bean("now")
    @Scope("prototype")
    public Temporal createNow()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("DateTimeConfig.createNow");
        Console.writeLine("--------------------------------------------------------------");
        return LocalDateTime.now();
    }

    @Bean("timeNow")
    @Scope("prototype")
    public Temporal createTimeNow()
    {
        return LocalTime.now();
    }
}

