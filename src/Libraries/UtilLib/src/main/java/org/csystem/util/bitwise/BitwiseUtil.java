/*----------------------------------------------------------------------
	FILE        : NumberUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 07.11.2021

	Utility class for bitwise operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.bitwise;

public final class BitwiseUtil {
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

    public static int [] indicesOfSetBits(int val)
    {
        var indices = new int[setBitsCount(val)];
        var idx = 0;

        for (int k = 0; k < 32; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }

    public static int [] indicesOfSetBits(long val)
    {
        var indices = new int[setBitsCount(val)];
        var idx = 0;

        for (int k = 0; k < 64; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }


    public static boolean isClear(int val, int k)
    {
        return !isSet(val, k);
    }

    public static boolean isClear(long val, int k)
    {
        return !isSet(val, k);
    }

    public static boolean isEven(int a)
    {
        return (a & 1) != 1;
    }
    public static boolean isEven(long a)
    {
        return (a & 1L) != 1;
    }

    public static boolean isPowerOfTwo(int val)
    {
        return val != 0 && (val & (val - 1)) == 0;
    }

    public static boolean isPowerOfTwo(long val)
    {
        return val != 0 && (val & (val - 1)) == 0;
    }

    public static boolean isSet(int val, int k)
    {
        return (val & 1 << k) != 0;
    }

    public static boolean isSet(long val, int k)
    {
        return (val & 1L << k) != 0;
    }

    public static int setBit(int val, int k) //k -> [0, 31]
    {
        return val | 1 << k;
    }

    public static long setBit(long val, int k) //k -> [0, 63]
    {
        return val | 1L << k;
    }


    public static int clearBitsCount(int val)
    {
        return 32 - setBitsCount(val);
    }

    public static int setBitsCount(int val)
    {
        var count = 0;

        for (int k = 0; k < 32; ++k)
            if (isSet(val, k))
                ++count;

        return count;
    }

    public static int clearBitsCount(long val)
    {
        return 64 - setBitsCount(val);
    }

    public static int setBitsCount(long val)
    {
        var count = 0;

        for (int k = 0; k < 64; ++k)
            if (isSet(val, k))
                ++count;

        return count;
    }

    public static String toBitsStr(byte val)
    {
        var bits = new char[8];

        for (int k = 7; k >= 0; --k)
            bits[7 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(short val)
    {
        var bits = new char[16];

        for (int k = 15; k >= 0; --k)
            bits[15 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(int val)
    {
        var bits = new char[32];

        for (int k = 31; k >= 0; --k)
            bits[31 - k] = (val & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(long val)
    {
        var bits = new char[64];

        for (int k = 63; k >= 0; --k)
            bits[63 - k] = (val & 1L << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(char ch)
    {
        var bits = new char[16];

        for (int k = 15; k >= 0; --k)
            bits[15 - k] = (ch & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static int toggleBit(int val, int k) // k -> [0, 31]
    {
        return  val ^ 1 << k;
    }

    public static long toggleBit(long val, int k) // k -> [0, 63]
    {
        return  val ^ 1L << k;
    }

    public static void writeBits(byte a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(short a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(int a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(long a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(char ch)
    {
        System.out.println(toBitsStr(ch));
    }
}
