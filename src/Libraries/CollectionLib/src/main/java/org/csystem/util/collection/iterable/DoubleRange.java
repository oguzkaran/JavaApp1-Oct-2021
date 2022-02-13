/*----------------------------------------------------------------------
	FILE        : DoubleRange.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 13.02.2022

	Iterable range class for double numbers

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.collection.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double>{
    private final double m_min;
    private final double m_max;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    private DoubleRange(double min, double max, DoubleUnaryOperator doubleUnaryOperator)
    {
        if (min > max)
            throw new IllegalArgumentException("Invalid Arguments");

        m_min = min;
        m_max = max;
        m_doubleUnaryOperator = doubleUnaryOperator;
    }

    public static DoubleRange of(double min, double max, double step)
    {
        return of(min, max, val -> val + step);
    }

    public static DoubleRange of(double min, double max, DoubleUnaryOperator doubleUnaryOperator)
    {
        return new DoubleRange(min, max, doubleUnaryOperator);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            double val = m_min;

            @Override
            public boolean hasNext()
            {
                return val < m_max;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                double result = val;

                val = m_doubleUnaryOperator.applyAsDouble(val);

                return result;
            }
        };
    }
}
