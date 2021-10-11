/*----------------------------------------------------------------------------------------------------------------------
    RandomIntGenerator sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.generator;

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
        return of(count, () -> random.nextInt(max - min) + min);
    }

    public static IntGenerator of(int count, IntSupplier intSupplier)
    {
        return new IntGenerator(count, intSupplier);
    }

    public int getCount()
    {
        return m_count;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int m_n;
            @Override
            public boolean hasNext()
            {
                return m_n + 1 < m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element");

                ++m_n;

                return m_supplier.getAsInt();
            }
        };
    }
}
