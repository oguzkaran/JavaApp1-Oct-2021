package org.csystem.app.randomuser.collector.scheduler;

import org.csystem.util.console.Console;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RandomUserScheduler {
    @Scheduled(fixedRate = 1000)
    public void schedule()
    {
        Console.writeLine("Schedule");
    }
}
