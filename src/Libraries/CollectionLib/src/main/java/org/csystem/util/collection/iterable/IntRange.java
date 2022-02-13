/*----------------------------------------------------------------------
	FILE        : IntRange.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 13.02.2022

	Iterable range class for int numbers

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.collection.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private final int m_min;
    private final int m_max;
    private final IntUnaryOperator m_intUnaryOperator;

    private IntRange(int min, int max, IntUnaryOperator intUnaryOperator)
    {
        if (min > max)
            throw new IllegalArgumentException("Invalid arguments");

        m_min = min;
        m_max = max;
        m_intUnaryOperator = intUnaryOperator;
    }

    public static IntRange of(int min, int bound) //[min, bound)
    {
        return of(min, bound, 1);
    }

    public static IntRange of(int min, int bound, int step) //[min, bound)
    {
        return ofClosed(min, bound - 1, step);
    }

    public static IntRange ofClosed(int min, int max) //[min, max]
    {
        return ofClosed(min, max, 1);
    }

    public static IntRange ofClosed(int min, int max, int step) //[min, max]
    {
        return ofClosed(min, max, (step <= 1) ? (val -> val + 1) : (val -> val + step));
    }

    public static IntRange ofClosed(int min, int max, IntUnaryOperator intUnaryOperator)
    {
        return new IntRange(min, max, intUnaryOperator);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int val = m_min;

            @Override
            public boolean hasNext()
            {
                return val <= m_max;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                int result = val;

                val = m_intUnaryOperator.applyAsInt(val);

                return result;
            }
        };
    }
}
