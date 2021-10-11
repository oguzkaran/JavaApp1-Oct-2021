/*----------------------------------------------------------------------
	FILE        : RandomIntGenerator.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 23.07.2021

	RandomIntGenerator iterable class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.iterable.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.IntSupplier;

public class RandomIntGenerator implements Iterable<Integer> {
    private final int m_count;
    private final IntSupplier m_supplier;

    private RandomIntGenerator(int count, IntSupplier supplier)
    {
        m_count = count;
        m_supplier = supplier;
    }

    public static RandomIntGenerator of(int count, int min, int max)
    {
        return of(new Random(), count, min, max);
    }

    public static RandomIntGenerator of(Random random, int count, int min, int max)
    {
        return of(count, () -> random.nextInt(max - min) + min);
    }

    public static RandomIntGenerator of(int count, IntSupplier supplier)
    {
        return new RandomIntGenerator(count, supplier);
    }

    public int getCount()
    {
        return m_count;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            private int m_count = -1;

            @Override
            public boolean hasNext()
            {
                return m_count + 1 < RandomIntGenerator.this.m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No value to generate");

                ++m_count;
                return m_supplier.getAsInt();
            }
        };
    }
}
