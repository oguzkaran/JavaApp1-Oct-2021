package org.csystem.application.runner.component;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ModulusOperation implements IOperation {
    @Value("${operation.modulus.left:1}")
    private int m_a;

    @Value("${operation.modulus.right:1}")
    private int m_b;

    @Value("${operation.modulus.prefix:Guray Modulus Operation}")
    private String m_prefix;

    @Override
    public void doOperation()
    {
        Console.writeLine("%s:%d %% %d = %d", m_prefix, m_a, m_b, m_a % m_b);
    }

    //...
}
