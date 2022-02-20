package org.csystem.application.numericlottery;

import java.util.Random;
import java.util.TreeSet;

public class NumericLottery {
    private final Random m_random;

    public NumericLottery()
    {
        this(new Random());
    }

    public NumericLottery(Random r)
    {
        m_random = r;
    }

    public int [] getNumbers()
    {
        var set = new TreeSet<Integer>();

        while (set.size() != 6)
            set.add(m_random.nextInt(49) + 1);

        //int türden diziye çevirme şimdilik bu şekilde yapılıyor
        int [] a = new int[6];

        int i = 0;

        for (var val : set)
            a[i++] = val;

        return a;
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
