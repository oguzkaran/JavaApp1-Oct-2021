package org.csystem.util.collection;

import java.util.Collection;
import java.util.Vector;

public class CSDVector<E> extends Vector<E> {
    private int m_capacityFactor;

    private void configureCapacityIncrement()
    {
        int curCapacity = capacity();

        if (curCapacity != size())
            return;

        capacityIncrement = m_capacityFactor * curCapacity - curCapacity;
    }

    public CSDVector(int initialCapacity, int capacityFactor)
    {
        super(initialCapacity);
        setCapacityFactor(capacityFactor);
    }

    public CSDVector(int capacityFactor)
    {
        setCapacityFactor(capacityFactor);
    }

    public CSDVector(Collection<? extends E> c, int capacityFactor)
    {
        super(c);
        setCapacityFactor(capacityFactor);
    }

    public void setCapacityFactor(int capacityFactor)
    {
        m_capacityFactor = capacityFactor <= 1 ? 2 : capacityFactor;
    }

    @Override
    public synchronized boolean add(E e)
    {
        if (e == null)
            throw new IllegalArgumentException("Element can not be null");

        configureCapacityIncrement();
        return super.add(e);
    }

    //...
}
