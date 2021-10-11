/*----------------------------------------------------------------------
	FILE        : LongPair.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 23.07.2021

	LongPair tuple class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.tuple;

public final class LongPair {
    private final long m_first;
    private final long m_second;

    public static LongPair create(long first, long second)
    {
        return new LongPair(first, second);
    }

    public LongPair(long first, long second)
    {
        m_first = first;
        m_second = second;
    }

    public long getFirst()
    {
        return m_first;
    }

    public long getSecond()
    {
        return m_second;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof LongPair && m_first == ((LongPair)obj).m_first && m_second == ((LongPair)obj).m_second;
    }

    @Override
    public String toString()
    {
        return String.format("{first : %d, second : %d}", m_first, m_second);
    }
}
