package org.csystem.app.samples.parser;

public class CharArraySource implements ISource {
    private final char [] m_chars;
    private int m_index;

    public CharArraySource(String str)
    {
        this(str.toCharArray());
    }

    public CharArraySource(char [] chars)
    {
        m_chars = chars;
    }

    public int getNextChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }

    public void reset()
    {
        m_index = 0;
    }
}
