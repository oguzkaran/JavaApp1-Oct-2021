package org.csystem.application.valueannotation.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AddOperation {
    @Value("${operation.add.left:0}")
    private int m_a;

    @Value("${operation.add.right:0}")
    private int m_b;

    @Value("${operation.add.prefix:Guray Add Operation}")
    private String m_prefix;

    @PostConstruct
    public void doOperation()
    {
        Console.writeLine("%s:%d + %d = %d", m_prefix, m_a, m_b, m_a + m_b);
    }

    //...
}
