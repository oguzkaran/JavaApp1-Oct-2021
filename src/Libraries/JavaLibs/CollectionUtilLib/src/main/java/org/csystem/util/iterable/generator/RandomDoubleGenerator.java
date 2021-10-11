/*----------------------------------------------------------------------
	FILE        : RandomDoubleGenerator.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 23.07.2021

	RandomDoubleGenerator iterable class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.iterable.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.DoubleSupplier;

public class RandomDoubleGenerator implements Iterable<Double> {
    private final int m_count;
    private final DoubleSupplier m_supplier;

    private RandomDoubleGenerator(int count, DoubleSupplier supplier)
    {
        m_count = count;
        m_supplier = supplier;
    }

    public static RandomDoubleGenerator of (int count, double min, double max)
    {
        return of(new Random(), count, min, max);
    }

    public static RandomDoubleGenerator of(Random random, int count, double min, double max)
    {
        return of(count, () -> random.nextDouble() * (max - min) + min);
    }

    public static RandomDoubleGenerator of(int count, DoubleSupplier supplier)
    {
        return new RandomDoubleGenerator(count, supplier);
    }

    public int getCount()
    {
        return m_count;
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            private int m_count = -1;

            @Override
            public boolean hasNext()
            {
                return m_count + 1 < RandomDoubleGenerator.this.m_count;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No value to generate");

                ++m_count;
                return m_supplier.getAsDouble();
            }
        };
    }
}
