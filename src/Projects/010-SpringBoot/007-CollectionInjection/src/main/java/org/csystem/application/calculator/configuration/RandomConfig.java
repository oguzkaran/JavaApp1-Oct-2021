package org.csystem.application.calculator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class RandomConfig {
    @Value("${seed}")
    private long m_seed;

    @Bean("randomCreateWithSeed")
    @Scope("prototype")
    public Random createRandomWithsSeed()
    {
        return new Random(m_seed);
    }

    @Bean("randomCreate")
    @Scope("prototype")
    public Random createRandom()
    {
        return new Random();
    }
}
