package org.csystem.app.simulation.passwdgenerator;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.CounterScheduler;
import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class PeriodicAsyncPasswordGenerator {
    private final String m_prefix;
    private final int m_n;
    private final int m_count;
    private final long m_period;
    private final ArrayList<BufferedWriter> m_bws;

    private void periodTaskCallback(BufferedWriter bw, Random random)
    {
        try  {
            bw.write(StringUtil.getRandomTextTR(random, 4) + "\r\n");
            bw.flush();
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Error:", ex.getMessage());
        }
    }

    public PeriodicAsyncPasswordGenerator(String prefix, int n, int count, long period)
    {
        m_prefix = prefix;
        m_n = n;
        m_count = count;
        m_period = period;
        m_bws = new ArrayList<>();
    }

    public void run()
    {
        try {
            for (int i = 0; i < m_n; ++i) {
                var bw = Files.newBufferedWriter(Path.of(m_prefix + "-" + i + ".txt"), StandardCharsets.UTF_8);
                var random = new Random();
                m_bws.add(bw);
                new CounterScheduler(m_count, m_period).schedule(() -> periodTaskCallback(bw, random));
            }
        }
        catch (IOException ex) {
            Console.Error.writeLine("IOError while opening files:", ex.getMessage());
        }
    }
}
