package org.csystem.app.ctorinjection.operation;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AddWithRandomValueOperation implements IIntBinaryOperation {
    private final Random m_random;

    public AddWithRandomValueOperation(Random random)
    {
        m_random = random;
    }

    @Override
    public boolean isValid(char op)
    {
        return op == '+';
    }

    @Override
    public int applyAsInt(int left, int right)
    {
        var a = m_random.nextInt(100);

        Console.writeLine("a = %d", a);

        return a + left + right;
    }
}
