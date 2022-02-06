package org.csystem.util.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRange implements Iterable<Integer> {
    private final int m_min;
    private final int m_max;
    private final int m_step;

    private IntRange(int min, int max, int step)
    {
        if (min > max || step < 1)
            throw new IllegalArgumentException("Invalid arguments");

        m_min = min;
        m_max = max;
        m_step = step;
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
        return new IntRange(min, max, step);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            int val = m_min - m_step;

            @Override
            public boolean hasNext()
            {
                return val + m_step <= m_max;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                return val += m_step;
            }
        };
    }
}
