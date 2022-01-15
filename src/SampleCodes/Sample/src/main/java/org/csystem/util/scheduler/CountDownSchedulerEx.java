/*----------------------------------------------------------------------
	FILE        : CountDownScheduleEx.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 15.01.2022

	Extension Class that is used for count-down operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public abstract class CountDownSchedulerEx extends CountDownScheduler {
    protected CountDownSchedulerEx(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, MILLISECONDS);
    }

    protected CountDownSchedulerEx(long millisInFuture, long interval, TimeUnit timeUnit)
    {
        super(millisInFuture, interval, timeUnit);
    }

    protected abstract void onStart();

    public final CountDownSchedulerEx startScheduler()
    {
        this.onStart();
        super.start();

        return this;
    }
}
