
package org.csystem.app.recursion;

public final class RecursionUtil {
    private RecursionUtil()
    {
    }

    private static int fibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return fibonacciNumberRecur(n - 1) + fibonacciNumberRecur(n - 2);
    }

    private static void reversedRecur(char [] c, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp = c[left];
        c[left] = c[right];
        c[right] = temp;

        reversedRecur(c, left + 1, right - 1);
    }

    private static void writeReverseRecur(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverseRecur(s, i + 1);
        System.out.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return  -1;

        return fibonacciNumberRecur(n);
    }


    public static String reversed(String s)
    {
        char [] c = s.toCharArray();

        reversedRecur(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    public static void writeReverse(String s)
    {
        writeReverseRecur(s, 0);
        System.out.flush();
    }
}
