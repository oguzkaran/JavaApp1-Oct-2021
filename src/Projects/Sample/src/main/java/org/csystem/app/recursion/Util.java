package org.csystem.app.recursion;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.console.Console;

public final class Util {
    private Util()
    {
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        long result = 1;

        for (; n > 1; --n)
            result *= n;

        return result;
    }
    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return n - 1;

        int prev1 = 1, prev2 = 0, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev2 = prev1;
            prev1 = val;
        }

        return val;
    }

    public static String reversed(String s)
    {
        char [] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return String.valueOf(chars);
    }

    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            Console.write(s.charAt(i));
    }
}
