/*----------------------------------------------------------------------
	FILE        : IntGenerator.java
	AUTHOR      : JavaApp1-Oct-2021 group
	LAST UPDATE : 13.02.2022

	Iterable int random number generator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.collection.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.IntSupplier;

public class IntGenerator implements Iterable<Integer> {
    private final int m_count;
    private final IntSupplier m_supplier;

    private IntGenerator(int count, IntSupplier supplier)
    {
        m_count = count;
        m_supplier = supplier;
    }

    public static IntGenerator of(Random random, int count, int min, int max)
    {
        return of(count, () -> random.nextInt(max - min + 1) + min);
    }

    public static IntGenerator of(int count, IntSupplier supplier)
    {
        return new IntGenerator(count, supplier);
    }

    //...

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int count;
            @Override
            public boolean hasNext()
            {
                return count + 1 <= m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                ++count;
                return m_supplier.getAsInt();
            }
        };
    }
}
