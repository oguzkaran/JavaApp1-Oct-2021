/*----------------------------------------------------------------------
	FILE        : Runnable.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 16.01.2022

	Interface that is the exception specific version of standard Runnable

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler.function;

@FunctionalInterface
public interface IRunnable {
    void run() throws Exception;
}
