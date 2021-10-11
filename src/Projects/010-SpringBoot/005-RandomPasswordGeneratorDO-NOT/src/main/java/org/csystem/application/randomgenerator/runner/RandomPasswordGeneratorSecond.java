package org.csystem.application.randomgenerator.runner;

import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;

@Component
public class RandomPasswordGeneratorSecond implements ApplicationRunner {
    private final BufferedWriter m_bufferedWriter;

    public RandomPasswordGeneratorSecond(@Qualifier("bufferedWriter.second") BufferedWriter bufferedWriter)
    {
        m_bufferedWriter = bufferedWriter;
    }

    @Value("${count}")
    private int m_count;

    @Value("${timeout}")
    private long m_timeout;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        for (int i = 0; i < m_count; ++i) {
            m_bufferedWriter.write(StringUtil.getRandomTextEN(10) + "\r\n");
            m_bufferedWriter.flush();
            Thread.sleep(m_timeout);
        }


    }
}

