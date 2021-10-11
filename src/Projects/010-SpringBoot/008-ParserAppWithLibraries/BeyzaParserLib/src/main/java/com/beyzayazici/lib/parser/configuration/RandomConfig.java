package com.beyzayazici.lib.parser.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomConfig {
    @Bean
    public Random getRandom()
    {
        return new Random();
    }
}
