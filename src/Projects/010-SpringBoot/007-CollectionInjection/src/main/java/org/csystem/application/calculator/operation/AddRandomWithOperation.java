package org.csystem.application.calculator.operation;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AddRandomWithOperation implements IIntBinaryOperator {
    private final Random m_random;

    public AddRandomWithOperation(@Qualifier("randomCreate") Random random)
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
        var val = m_random.nextInt(99);

        Console.writeLine("val = %d", val);

        return left + right + val;
    }
}
