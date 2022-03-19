package org.csystem.app.random.passwordgen.runner;

import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.util.Random;

@Component
public class FirstGeneratorRunner implements ApplicationRunner {
    private final BufferedWriter m_bw;
    private final Random m_random;

    @Value("${count}")
    private int m_count;

    @Value("${interval}")
    private long m_interval;

    public FirstGeneratorRunner(@Qualifier("bufferedWriterPath1") BufferedWriter bw, Random random)
    {
        m_bw = bw;
        m_random = random;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        for (int i = 0; i < m_count; ++i) {
            m_bw.write(StringUtil.getRandomTextTR(m_random, 10) + "\r\n");
            m_bw.flush();
            Thread.sleep(m_interval);
        }
    }
}
