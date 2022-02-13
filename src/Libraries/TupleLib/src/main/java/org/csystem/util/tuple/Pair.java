/*----------------------------------------------------------------------
	FILE        : Pair.java
	AUTHOR      : JavaApp-Oct-2021 Group
LAST UPDATE : 13.02.2022

	Immutable Pair class that represents Tuple<F, S>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.tuple;

public final class Pair<F, S> {
    private final F m_first;
    private final S m_second;

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public Pair()
    {
        m_first = null;
        m_second = null;
    }

    public Pair(F first, S second)
    {
        m_first = first;
        m_second = second;
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    @Override
    public boolean equals(Object other)
    {
        @SuppressWarnings("unchecked")
        var p = (Pair<F, S>)other;

        return m_first.equals(p.m_first) && m_second.equals(p.m_second);
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", m_first, m_second);
    }

    //...
}
