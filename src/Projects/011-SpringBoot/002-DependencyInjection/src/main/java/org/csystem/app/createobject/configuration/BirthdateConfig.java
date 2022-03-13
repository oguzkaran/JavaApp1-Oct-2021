package org.csystem.app.createobject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;

@Configuration
public class BirthdateConfig {
    @Bean("birthdateConfigGetNow")
    @Scope("prototype")
    public Temporal getNow()
    {
        return LocalDateTime.now();
    }

    @Bean("birthdateConfigGetBirthDate")
    @Scope("prototype")
    public Temporal getBirthDate()
    {
        return LocalDate.of(1976, Month.SEPTEMBER, 10);
    }

    @Bean("birthdateConfigGetToday")
    @Scope("prototype")
    public Temporal getToday()
    {
        return LocalDate.now();
    }
}
