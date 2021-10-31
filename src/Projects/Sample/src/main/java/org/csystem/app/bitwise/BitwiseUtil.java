/*----------------------------------------------------------------------
	FILE        : NumberUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 31.10.2021

	Utility class for bitwise operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.app.bitwise;

import org.csystem.util.console.Console;

public final class BitwiseUtil {
    private static void writeBits(String bitStr, int bitsLength)
    {
        var lengthOfZeros = bitsLength - bitStr.length();

        Console.writeLine(lengthOfZeros != 0 ? String.format("%0" + lengthOfZeros + "d%s", 0, bitStr) : bitStr);
    }

    private BitwiseUtil()
    {
    }

    public static int clearBit(int val, int k) //k -> [0, 31]
    {
        return val & ~(1 << k);
    }

    public static long clearBit(long val, int k) //k -> [0, 63]
    {
        return val & ~(1L << k);
    }

    public static int setBit(int val, int k) //k -> [0, 31]
    {
        return val | 1 << k;
    }

    public static long setBit(long val, int k) //k -> [0, 63]
    {
        return val | 1L << k;
    }

    public static int toggleBit(int val, int k) // k -> [0, 31]
    {
        return  val ^ 1 << k;
    }

    public static long toggleBit(long val, int k) // k -> [0, 63]
    {
        return  val ^ 1L << k;
    }

    public static void writeBits(int a)
    {
        writeBits(Integer.toBinaryString(a), 32);
    }

    public static void writeBits(long a)
    {
        writeBits(Long.toBinaryString(a), 64);
    }

}
