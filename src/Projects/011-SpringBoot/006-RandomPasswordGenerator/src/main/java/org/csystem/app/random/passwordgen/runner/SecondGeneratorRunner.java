package org.csystem.app.random.passwordgen.runner;

import org.csystem.util.scheduler.Scheduler;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.util.Random;

@Component
public class SecondGeneratorRunner implements ApplicationRunner {
    private final BufferedWriter m_bw;
    private final Random m_random;
    private final Scheduler m_scheduler;

    @Value("${count}")
    private int m_count;

    private void passwordGeneratorSchedulerCallback() throws Exception
    {
        if (m_count == 0) {
            m_scheduler.cancel();
            return;
        }
        m_bw.write(StringUtil.getRandomTextTR(m_random, 10) + "\r\n");
        m_bw.flush();
        --m_count;
    }

    public SecondGeneratorRunner(@Qualifier("bufferedWriterPath2") BufferedWriter bw, Random random, Scheduler scheduler)
    {
        m_bw = bw;
        m_random = random;
        m_scheduler = scheduler;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        m_scheduler.schedule(this::passwordGeneratorSchedulerCallback);
    }
}
