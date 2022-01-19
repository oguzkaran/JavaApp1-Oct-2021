/*----------------------------------------------------------------------
	FILE        : CommandLineUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 19.01.2022

	Utility class for command line arguments

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.console.command;

import org.csystem.util.console.Console;

public final class CommandLineUtil {
    private CommandLineUtil()
    {}

    public static void checkForLengthEqual(String [] args, int count, String errMessage, int exitCode)
    {
        if (args.length != count) {
            Console.Error.writeLine(errMessage);
            System.exit(exitCode);
        }
    }

    public static void checkForLengthGreater(String [] args, int count, String errMessage, int exitCode)
    {
        if (args.length > count) {
            Console.Error.writeLine(errMessage);
            System.exit(exitCode);
        }
    }

    public static void checkForLengthGreaterOrEqual(String [] args, int count, String errMessage, int exitCode)
    {
        checkForLengthGreater(args, count + 1, errMessage, exitCode);
    }


    public static void checkForLengthLess(String [] args, int count, String errMessage, int exitCode)
    {
        if (args.length < count) {
            Console.Error.writeLine(errMessage);
            System.exit(exitCode);
        }
    }

    public static void checkForLengthLessOrEqual(String [] args, int count, String errMessage, int exitCode)
    {
        checkForLengthLess(args, count + 1, errMessage, exitCode);
    }

    public static String getCommandLineArgs(String [] args, String stdIntMessage, String delimiter)
    {
        return args.length == 0 ? Console.read(stdIntMessage) : String.join(delimiter, args);
    }

    public static String getCommandLineArgs(String [] args, String stdIntMessage, char delimiter)
    {
        return getCommandLineArgs(args, stdIntMessage, delimiter + "");
    }
}
