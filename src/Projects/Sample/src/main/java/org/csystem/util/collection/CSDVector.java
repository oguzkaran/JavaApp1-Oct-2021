/*----------------------------------------------------------------------------------------------------------------------
    CSDVector sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Collection;
import java.util.Vector;

public class CSDVector<E> extends Vector<E> {
    private int m_capacityFactor;

    private void configureCapacityInc()
    {
        if (capacity() != size())
            return;

        int curCapacity = capacity();

        capacityIncrement = curCapacity * m_capacityFactor - curCapacity;
    }

    public CSDVector()
    {
    }

    public CSDVector(int initialCapacity)
    {
        super(initialCapacity);
    }

    public CSDVector(int initialCapacity, int capacityFactor)
    {
        this(initialCapacity);
        setCapacityFactor(capacityFactor);
    }

    public CSDVector(Collection<? extends E> collection)
    {
        addAll(collection);
    }

    public void setCapacityFactor(int capacityFactor)
    {
        m_capacityFactor = capacityFactor <= 1 ? 2 : capacityFactor;
    }

    @Override
    public boolean add(E e)
    {
        if (e == null)
            throw new IllegalArgumentException("Element can not be null");

        this.configureCapacityInc();

        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        if (c.contains(null))
            throw new IllegalArgumentException("Collection contains null value");

        this.configureCapacityInc();

        return super.addAll(c);
    }

    //...
}
