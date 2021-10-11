package org.csystem.library.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.csystem.library.parser.ComponentName.CHAR_ARRAY_SOURCE;
import static org.csystem.library.parser.ComponentName.CHAR_ARRAY_SOURCE_INJECT_BEAN_NAME;

@Component(CHAR_ARRAY_SOURCE)
@Scope("prototype")
public class CharArraySource implements ISource {
    private final char [] m_chars;
    private int m_index;

    @Autowired
    public CharArraySource(@Qualifier(CHAR_ARRAY_SOURCE_INJECT_BEAN_NAME) String str)
    {
        this(str.toCharArray());
    }

    public CharArraySource(char [] chars)
    {
        m_chars = chars;
    }

    public int nextChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }

    public void reset()
    {
        m_index = 0;
    }
}
