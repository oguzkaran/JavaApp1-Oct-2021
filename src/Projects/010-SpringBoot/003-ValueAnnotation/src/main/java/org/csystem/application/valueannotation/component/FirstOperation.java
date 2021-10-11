package org.csystem.application.valueannotation.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstOperation {
    @Value("${operation.first.operand1}")
    private int m_a;

    @Value("${operation.first.operand2}")
    private int m_b;

    @Value("${operation.first.prefix}")
    private String m_prefix;

    @PostConstruct
    public void doOperation()
    {
        Console.writeLine("%s:%d + %d = %d", m_prefix, m_a, m_b, m_a + m_b);
    }
}
