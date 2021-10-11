package org.csystem.application.randomgenerator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Timer;

@Configuration
public class TimerConfig {
    @Bean
    @Scope("prototype")
    public Timer createTimer()
    {
        return new Timer();
    }
}
