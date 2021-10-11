/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class ArrayUtil {
    private ArrayUtil()
    {
    }

    public static void display(int n, int... a)
    {
        display(n, a.length, a);
    }

    public static void display(int n, int count, int... a)
    {
        String fmt = String.format("%%0%dd ", n);

        IntStream.range(0,  count).forEach(i -> System.out.printf(fmt, a[i]));
        System.out.println();
    }

    public static void display(int... a)
    {
        display(1, a.length, a);
    }

    public static void display(int[]...a)
    {
        display(1, a);
    }

    public static void display(int n, int[]...a)
    {
        Stream.of(a).forEach(array -> display(n, array));
    }

    public static void display(char...c)
    {
        IntStream.range(0, c.length).forEach(i -> System.out.printf("%c ", c[i]));
        System.out.println();
    }

    public static void display(BigInteger...bigIntegers)
    {
        Stream.of(bigIntegers).forEach(System.out::println);
    }

    public static void drawHistogram(int[] data, int n, char ch)
    {
        OptionalInt optInt = Arrays.stream(data).max();

        if (optInt.isEmpty())
            return;

        int maxVal = optInt.getAsInt();

        IntStream.of(data).forEach(value -> {
            int val = (int) Math.round(value * n / (double) maxVal);

            System.out.println((ch + "").repeat(val));
        });
    }

    public static int[] enlarge(int[] a, int newLength)
    {
        if (newLength <= a.length)
            return a;

        return Arrays.copyOf(a, newLength);
    }

    public static boolean equals(int [][] a, int [][] b)
    {
        if (a.length != b.length)
            return false;

        return IntStream.range(0, a.length).allMatch(i -> Arrays.equals(a[i], b[i]));
    }

    public static int[] getHistogramData(int[] a, int n) //[0, n]
    {
        int[] counts = new int[n + 1];

        IntStream.of(a).forEach(val -> ++counts[val]);

        return counts;
    }

    public static int[][] getTranspose(int[][] a)
    {
        int row = a.length;
        int col = a[0].length;

        int[][] t = new int[col][row];

        IntStream.range(0, row).forEach(i -> IntStream.range(0, col).forEach(j -> t[j][i] = a[i][j]));

        return t;
    }

    public static int[] resize(int[] a, int newLength)
    {
        if (a.length == newLength)
            return a;

        int[] newArray = new int[newLength];
        int length = Math.min(a.length, newLength);

        System.arraycopy(a, 0, newArray, 0, length);

        return newArray;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] c, int i, int k)
    {
        char temp = c[i];

        c[i] = c[k];
        c[k] = temp;
    }

    public static long toNumber(int[] a)
    {
        return LongStream.range(0, a.length).reduce(0, (r, i) -> r + (long) a[(int)i] * (long) Math.pow(10, a.length - 1 - i));
    }
}
