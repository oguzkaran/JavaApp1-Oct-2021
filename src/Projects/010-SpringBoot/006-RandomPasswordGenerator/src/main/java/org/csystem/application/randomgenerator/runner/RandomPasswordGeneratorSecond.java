package org.csystem.application.randomgenerator.runner;

import org.csystem.util.Console;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class RandomPasswordGeneratorSecond implements ApplicationRunner {
    private final BufferedWriter m_bufferedWriter;
    private final Random m_random;
    private final Timer m_timer;

    private void timerTaskCallback()
    {
        try {
            m_bufferedWriter.write(StringUtil.getRandomTextEN(m_random, 10) + "\r\n");
            m_bufferedWriter.flush();
        }
        catch (IOException ex) {
            Console.Error.writeLine(ex.getMessage());
        }
    }

    public RandomPasswordGeneratorSecond(@Qualifier("bufferedWriter.second") BufferedWriter bufferedWriter,
                                         Random random,
                                         Timer timer)
    {
        m_bufferedWriter = bufferedWriter;
        m_random = random;
        m_timer = timer;
    }

    @Value("${count}")
    private int m_count;

    @Value("${timeout}")
    private long m_timeout;

    private int m_n;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                ++m_n;
                if (m_n == m_count) {
                    m_timer.cancel();
                    return;
                }

                timerTaskCallback();
            }
        }, 0, m_timeout);
    }
}

