/*----------------------------------------------------------------------
	FILE        : StopWatch.java
	AUTHOR      : Oğuz Karan, JavaApp1-Oct-2021 group
	LAST UPDATE : 28.11.2021

	Class that can be used to measure time for codes

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime.stopwatch;

import java.util.concurrent.TimeUnit;

public class StopWatch {
    private long m_start;
    private long m_stop;

    public void start()
    {
        m_start = System.nanoTime();
    }

    public void stop()
    {
        m_stop = System.nanoTime();
    }

    public long getStart()
    {
        return m_start;
    }

    public long getStop()
    {
        return m_stop;
    }

    public long getElapsed(TimeUnit timeUnit)
    {
        return timeUnit.convert(m_stop - m_start, TimeUnit.NANOSECONDS);
    }

    public long getElapsedAsNano()
    {
        return m_stop - m_start;
    }


}
