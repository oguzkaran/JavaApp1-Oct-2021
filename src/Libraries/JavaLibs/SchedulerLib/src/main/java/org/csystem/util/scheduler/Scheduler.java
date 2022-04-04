/*----------------------------------------------------------------------
	FILE        : Scheduler.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 16.01.2022

	Scheduler class for timer operations with functional
	programming support

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import org.csystem.util.scheduler.function.IRunnable;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Scheduler {
    private final Timer m_timer;
    private final long m_delay;
    private final long m_period;
    private IRunnable m_cancelTask;

    public Scheduler(long period)
    {
        this(0, period);
    }

    public Scheduler(long delay, long period)
    {
        this(delay, period, TimeUnit.MILLISECONDS);
    }

    public Scheduler(long period, TimeUnit timeUnit)
    {
        this(0, period, timeUnit);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        m_timer = new Timer();
        m_delay = timeUnit == MILLISECONDS ? delay : MILLISECONDS.convert(delay, timeUnit);
        m_period = timeUnit == MILLISECONDS ? period : MILLISECONDS.convert(period, timeUnit);
    }

    public final Scheduler schedule(IRunnable task)
    {
        return schedule(task, null);
    }

    public final Scheduler schedule(IRunnable task, IRunnable cancelTask)
    {
        m_cancelTask = cancelTask;

        m_timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                try {
                    task.run();
                }
                catch (Exception ex) {

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
        catch (Exception ex) {
            //...
        }
    }
}
