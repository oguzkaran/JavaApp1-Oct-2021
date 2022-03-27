package org.csystem.app.clientinfo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {
    @Bean
    @Scope("prototype")
    public LocalDateTime now()
    {
        return LocalDateTime.now();
    }

    @Bean
    public DateTimeFormatter formatter()
    {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
    }
}
