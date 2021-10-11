/*--------------------------------------------------------------------------------------------------------------------
    NumericLotto sınıfı
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.sample;

import java.util.Random;
import java.util.TreeSet;

public class NumericLottery {
    private final Random m_random;

    public NumericLottery()
    {
        m_random = new Random();
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

        //int türden diziye çevirme şimdilik bu şekilde yapıldı
        int [] a = new int[6];

        int i = 0;

        for (var val : set)
            a[i++] = val;

        return a;
    }

    public int [][] getNumbers(int n)
    {
        int [][] result = new int[n][];

        for (int i = 0; i < n; ++i)
            result[i] = getNumbers();

        return result;
    }
}
