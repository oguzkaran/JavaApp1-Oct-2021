package org.csystem.application.randomprimenumbergenerator;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;
import org.csystem.util.scheduler.Scheduler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomPrimeNumberGenerator implements Closeable {
    private final int m_count;
    private final BufferedWriter m_bw;

    private final Scheduler m_scheduler;
    private final Random m_random;
    private int m_n;

    private void taskCallback() throws IOException
    {
        if (m_n == m_count) {
            m_scheduler.cancel();
            return;
        }
        var val = m_random.nextLong();

        if (NumberUtil.isPrime(val)) {
            ++m_n;
            Console.writeLine("%d", val);
            m_bw.write(val + "\r\n");
            m_bw.flush();
        }
    }

    public RandomPrimeNumberGenerator(int count, long period, TimeUnit timeUnit, String path) throws IOException
    {
        m_count = count;
        m_bw = new BufferedWriter(new FileWriter(path, StandardCharsets.US_ASCII, true));
        m_scheduler = new Scheduler(period, timeUnit);
        m_random = new Random();
    }

    public void run()
    {
        m_scheduler.schedule(this::taskCallback);
    }

    @Override
    public void close() throws IOException
    {
        m_bw.close();
    }
}
