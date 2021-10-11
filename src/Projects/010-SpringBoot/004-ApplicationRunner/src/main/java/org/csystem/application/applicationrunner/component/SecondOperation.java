package org.csystem.application.applicationrunner.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecondOperation {
    @Value("${operation.second.operand1}")
    private int m_a;

    @Value("${operation.second.operand2}")
    private int m_b;

    @Value("${operation.second.prefix}")
    private String m_prefix;

    public void doOperation()
    {
        Console.writeLine("%s:%d + %d = %d", m_prefix, m_a, m_b, m_a + m_b);
    }
}
