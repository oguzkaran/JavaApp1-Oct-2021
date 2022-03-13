package org.csystem.application.valueannotation.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MultiplyOperation {
    @Value("${operation.multiply.left:1}")
    private int m_a;

    @Value("${operation.multiply.right:1}")
    private int m_b;

    @Value("${operation.multiply.prefix:Guray Multiply Operation}")
    private String m_prefix;

    @PostConstruct
    public void doOperation()
    {
        Console.writeLine("%s:%d * %d = %d", m_prefix, m_a, m_b, m_a * m_b);
    }

    //...
}
