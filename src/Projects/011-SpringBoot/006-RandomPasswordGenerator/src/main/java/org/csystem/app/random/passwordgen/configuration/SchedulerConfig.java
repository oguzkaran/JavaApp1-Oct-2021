package org.csystem.app.random.passwordgen.configuration;

import org.csystem.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SchedulerConfig {
    @Bean
    @Scope("prototype")
    public Scheduler createScheduler(@Value("${interval}") long interval)
    {
        return new Scheduler(interval);
    }
}
