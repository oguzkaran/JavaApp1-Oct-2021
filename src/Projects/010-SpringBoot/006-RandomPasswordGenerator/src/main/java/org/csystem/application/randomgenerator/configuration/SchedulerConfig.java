package org.csystem.application.randomgenerator.configuration;

import org.csystem.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

@Configuration
public class SchedulerConfig {
    @Bean
    @Scope("prototype")
    public Scheduler createScheduler(@Value("${timeout}") long timeout, @Value("${timeoutStr}") String timeoutStr)
    {
        return new Scheduler(timeout, TimeUnit.valueOf(timeoutStr));
    }
}
