package org.csystem.application.randomgenerator.runner;

import org.csystem.util.Console;
import org.csystem.util.scheduler.Scheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;

@Component
public class RandomPasswordGeneratorFirst implements ApplicationRunner {
    private final BufferedWriter m_bufferedWriter;
    private final Random m_random;
    private final Scheduler m_scheduler;

    @Value("${count}")
    private int m_count;

    @Value("${timeout}")
    private long m_timeout;

    private int m_n;

    private void schedulerCallback()
    {
        try {
            if (m_count == m_n)
                m_scheduler.cancel();
            ++m_n;
            m_bufferedWriter.write(StringUtil.getRandomTextEN(m_random, 10) + "\r\n");
            m_bufferedWriter.flush();
        }
        catch (IOException ex) {
            Console.Error.writeLine(ex.getMessage());
        }
    }

    public RandomPasswordGeneratorFirst(@Qualifier("bufferedWriter.first") BufferedWriter bufferedWriter,
                                        Random random,
                                        Scheduler scheduler)
    {
        m_bufferedWriter = bufferedWriter;
        m_random = random;
        m_scheduler = scheduler;
    }



    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_scheduler.schedule(this::schedulerCallback);
    }
}

