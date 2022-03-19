package org.csystem.app.ctorinjection.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class RandomConfig {
    @Bean
    @Scope("prototype")
    public Random createRandom()
    {
        return new Random();
    }
}
