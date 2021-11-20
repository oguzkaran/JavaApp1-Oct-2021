/*----------------------------------------------------------------------
	FILE        : CommandLineUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 20.11.2021

	Utility class for command line arguments

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.command;

import java.util.Scanner;

public final class CommandLineUtil {
    private static final Scanner ms_stdin = new Scanner(System.in);

    private CommandLineUtil()
    {}

    public static String [] getCommandLineArgs(String [] args, String inputMessage)
    {
        if (args.length > 0)
            return args;

        System.out.print(inputMessage);
        return ms_stdin.nextLine().split("[ \t]+");
    }
}
