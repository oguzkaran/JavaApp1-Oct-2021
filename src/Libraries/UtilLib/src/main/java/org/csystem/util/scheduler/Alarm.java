/*----------------------------------------------------------------------
	FILE        : Alarm.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 16.01.2022

	Alarm class for clock alarm operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import org.csystem.util.function.IRunnable;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Alarm {
    private final Scheduler m_scheduler;
    private final LocalTime m_time;

    private void scheduleCallback(IRunnable periodTask)
    {
        try {
            if (periodTask != null)
                periodTask.run();

            LocalTime now = LocalTime.now();

            now = now.withNano(0);

            if (m_time.equals(now))
                m_scheduler.cancel();
        }
        catch (Exception ignore) {
            //...
        }
    }

    public Alarm(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Alarm(int hour, int minute, int second)
    {
        this(LocalTime.of(hour, minute, second));
    }

    public Alarm(LocalTime time)
    {
        m_time = time;
        m_scheduler = new Scheduler(1, TimeUnit.SECONDS);
    }

    public Alarm start(IRunnable alarmTask)
    {
        return start(alarmTask, null);
    }

    public Alarm start(IRunnable alarmTask, IRunnable periodTask)
    {
        m_scheduler.schedule(() -> scheduleCallback(periodTask), alarmTask);

        return this;
    }
}
