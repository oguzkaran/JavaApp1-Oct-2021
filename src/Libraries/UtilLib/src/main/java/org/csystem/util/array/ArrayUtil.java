/*----------------------------------------------------------------------
	FILE        : ArrayUtil.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 23.10.2021

	Utility class for array operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.array;

import java.util.Random;

public final class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (var i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }

            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (var i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }

            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }


    public static int [] copyOf(int [] a, int newLength)
    {
        var r = new int[newLength];

        var length = Math.min(a.length, newLength);

        for (var i = 0; i < length; ++i)
            r[i] = a[i];

        return r;
    }

    public static void display(int [] a)
    {
        display(1, a);
    }

    public static void display(int n, int...a)
    {
        var fmt = String.format("%%0%dd ", n);

        for (var val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(int n, int []...a)
    {
        for (var array : a)
            display(n, array);
    }

    public static void display(String...str)
    {
        display('\n', str);
    }

    public static void display(char sep, String...str)
    {
        for (var s : str)
            System.out.printf("%s%c", s, sep);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        var mavValue = max(data);

        for (var val : data) {
            var count = (int)Math.ceil((double)val * n / mavValue);

            while (count -- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static void fillRandomArray(int [] a, int min, int max) //[min, max)
    {
        fillRandomArray(new Random(), a, min, max);
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max) //[min, max)
    {
        for (var i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min + 1) + min;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max]
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max]
    {
        var a = new int[n];

        fillRandomArray(r, a, min, max);

        return a;
    }

    public static int [][] getRandomMatrix(int row, int col, int min, int max)
    {
        return getRandomMatrix(new Random(), row, col, min, max);
    }

    public static int [][] getRandomMatrix(Random r, int row, int col, int min, int max)
    {
        var m = new int[row][];

        for (var i = 0; i < row; ++i)
            m[i] = getRandomArray(r, col, min, max);

        return m;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        var data = new int[n + 1];

        for (var val : a)
            ++data[val];

        return data;
    }

    public static boolean isMatrix(int [][] a)
    {
        for (var i = 1; i < a.length; ++i)
            if (a[i].length != a[0].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static int max(int [] a)
    {
        var result = a[0];

        for (var i = 1; i < a.length; ++i)
            if (result < a[i])
                result = a[i];

        return result;
    }

    public static int min(int [] a)
    {
        var result = a[0];

        for (var i = 1; i < a.length; ++i)
            if (result > a[i])
                result = a[i];

        return result;
    }

    public static int partition(int [] a, int threshold)
    {
        var partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (var i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        var halfLength = a.length / 2;

        for (int i = 0; i < halfLength; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] a)
    {
        var halfLength = a.length / 2;

        for (int i = 0; i < halfLength; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static int sum(int [] a)
    {
        var total = 0;

        for (var val : a)
            total += val;

        return total;
    }


    public static int sum(int [][] a)
    {
        var total = 0;

        for (int[] array : a)
            total += sum(array);

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        var total = 0;

        for (var i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(double [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static int [][] transpose(int [][] a)
    {
        int row = a.length;
        int col = a[0].length;
        var t = new int[col][row];

        for (var i = 0; i < row; ++i)
            for (var j = 0; j < col; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
