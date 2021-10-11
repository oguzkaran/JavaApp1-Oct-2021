package org.csystem.application.applicationrunner.runner;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstOperationRunner implements ApplicationRunner  {
    @Value("${operation.first.operand1}")
    private int m_a;

    @Value("${operation.first.operand2}")
    private int m_b;

    @Value("${operation.first.prefix}")
    private String m_prefix;

    @Override
    public void run(ApplicationArguments args)
    {
        Console.writeLine("%s:%d + %d = %d", m_prefix, m_a, m_b, m_a + m_b);
    }
}
