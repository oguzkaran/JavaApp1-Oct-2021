/*----------------------------------------------------------------------
	FILE        : CounterScheduler.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 16.01.2022

	CounterScheduler class for timer operations with functional
	programming support

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import org.csystem.util.function.IRunnable;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class CounterScheduler {
    private final Timer m_timer;
    private final long m_delay;
    private final long m_period;
    private int m_count;
    private IRunnable m_cancelTask;

    public CounterScheduler(int count, long period)
    {
        this(count, 0, period);
    }

    public CounterScheduler(int count, long delay, long period)
    {
        this(count, delay, period, TimeUnit.MILLISECONDS);
    }

    public CounterScheduler(int count, long period, TimeUnit timeUnit)
    {
        this(count, 0, period, timeUnit);
    }

    public CounterScheduler(int count, long delay, long period, TimeUnit timeUnit)
    {
        m_count = count;
        m_delay = timeUnit == MILLISECONDS ? delay : MILLISECONDS.convert(delay, timeUnit);
        m_period = timeUnit == MILLISECONDS ? period : MILLISECONDS.convert(period, timeUnit);
        m_timer = new Timer();
    }

    public final CounterScheduler schedule(IRunnable task)
    {
        return schedule(task, null);
    }

    public final CounterScheduler schedule(IRunnable task, IRunnable cancelTask)
    {
        m_cancelTask = cancelTask;

        m_timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                try {
                    task.run();
                    --m_count;
                    if (m_count == 0)
                        m_timer.cancel();
                }
                catch (Exception ignore) {

                }
            }
        }, m_delay, m_period);

        return this;
    }

    public final void cancel()
    {
        try {
            if (m_cancelTask != null)
                m_cancelTask.run();

            m_timer.cancel();
        }
        catch (Exception ignore) {

        }
    }
}
