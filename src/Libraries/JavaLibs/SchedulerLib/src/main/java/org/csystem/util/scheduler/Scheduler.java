/*----------------------------------------------------------------------------------------------------------------------
    Scheduler class
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public final class Scheduler {
    private final Timer m_timer;
    private final long m_delay;
    private final long m_period;
    private IRunnable m_cancelTask;

    public Scheduler(long period)
    {
        this(0, period, MILLISECONDS);
    }

    public Scheduler(long delay, long period)
    {
        this(delay, period, MILLISECONDS);
    }

    public Scheduler(long period, TimeUnit timeUnit)
    {
        this(0, period, timeUnit);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        m_timer = new Timer();
        m_delay = timeUnit != MILLISECONDS ? MILLISECONDS.convert(delay, timeUnit) : delay;
        m_period = timeUnit != MILLISECONDS ? MILLISECONDS.convert(period, timeUnit) : period;
    }

    public void schedule(IRunnable task)
    {
        schedule(task, null);
    }

    public void schedule(IRunnable task, IRunnable cancelTask)
    {
        m_cancelTask = cancelTask;

        m_timer.schedule(new TimerTask() {
            public void run()
            {
                try {
                    task.run();
                }
                catch (Throwable ignore) {

                }
            }
        }, m_delay, m_period);
    }

    public void cancel()
    {
        try {
            if (m_cancelTask != null)
                m_cancelTask.run();

            m_timer.cancel();
        }
        catch (Throwable ignore) {

        }
    }
}

