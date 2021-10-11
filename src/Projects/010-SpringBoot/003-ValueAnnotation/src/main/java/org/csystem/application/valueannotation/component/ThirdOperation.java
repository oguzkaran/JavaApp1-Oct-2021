package org.csystem.application.valueannotation.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ThirdOperation {
    @Value("${operation.third.operand1:67}")
    private int m_a;

    @Value("${operation.third.operand2:109}")
    private int m_b;

    @Value("${operation.third.prefix:Onur}")
    private String m_prefix;

    @PostConstruct
    public void doOperation()
    {
        Console.writeLine("%s:%d + %d = %d", m_prefix, m_a, m_b, m_a + m_b);
    }
}
