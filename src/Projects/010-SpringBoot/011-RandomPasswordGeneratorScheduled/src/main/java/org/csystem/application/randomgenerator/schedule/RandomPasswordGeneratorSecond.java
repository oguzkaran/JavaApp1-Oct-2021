package org.csystem.application.randomgenerator.schedule;

import org.csystem.util.Console;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

@Component
public class RandomPasswordGeneratorSecond {
    private final BufferedWriter m_bufferedWriter;
    private final Random m_random;

    private void scheduledCallback()
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
                                         Random random)
    {
        m_bufferedWriter = bufferedWriter;
        m_random = random;
    }

    @Value("${count}")
    private int m_count;

    private int m_n;

    @Scheduled(fixedRate = 1000)
    public void run()
    {
        if (m_count == m_n)
            System.exit(1);

        ++m_n;

        scheduledCallback();
    }
}

