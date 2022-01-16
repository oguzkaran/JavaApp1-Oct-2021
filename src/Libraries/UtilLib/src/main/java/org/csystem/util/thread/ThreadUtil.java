/*----------------------------------------------------------------------
	FILE        : ThreadUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 16.01.2022

	Utility class for thread operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.thread;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class ThreadUtil {
    public static void sleep(long timout, TimeUnit timeUnit)
    {
        try {
            Thread.sleep(timeUnit == MILLISECONDS ? timout : MILLISECONDS.convert(timout, timeUnit));
        }
        catch (InterruptedException ignore) {

        }
    }

    public static void sleep(long millis)
    {
        sleep(millis, MILLISECONDS);
    }
}
