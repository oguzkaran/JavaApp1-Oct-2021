package org.csystem.application.calculator.operation;

import org.csystem.util.Console;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SampleCalculator {
    private final Collection<IIntBinaryOperator> m_operations;

    public void throwException(char op)
    {
        throw new UnsupportedOperationException("Unsupported operation:" + op);
    }

    public SampleCalculator(Collection<IIntBinaryOperator> operations)
    {
        m_operations = operations;
        Console.writeLine("Size:%d%n", m_operations.size());
    }

    public void calculate(int a, int b, char op)
    {
        m_operations.stream()
                .filter(ibo -> ibo.isValid(op))
                .findFirst()
                .ifPresentOrElse(ibo -> Console.writeLine("%d %c %d = %d", a, op, b, ibo.applyAsInt(a, b)),
                        () -> throwException(op));
    }

    public void calculateForAll(int a, int b, char op)
    {
        m_operations.stream()
                .filter(ibo -> ibo.isValid(op))
                .forEach(ibo -> Console.writeLine("%d %c %d = %d", a, op, b, ibo.applyAsInt(a, b)));
    }
}
