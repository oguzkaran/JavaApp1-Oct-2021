package org.csystem.app.random.passwordgen.configuration;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Scheduler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomGeneratorConfig {
    private final Scheduler m_scheduler;
    private final Random m_random;

    private void schedulerCallback()
    {
        Console.write("%d ", m_random.nextInt(100));
    }

    public RandomGeneratorConfig(Scheduler scheduler, Random random)
    {
        m_scheduler = scheduler;
        m_random = random;
    }

    @Bean
    public ApplicationRunner runRandomNumberGenerator()
    {
        return a -> m_scheduler.schedule(this::schedulerCallback);
    }
}
