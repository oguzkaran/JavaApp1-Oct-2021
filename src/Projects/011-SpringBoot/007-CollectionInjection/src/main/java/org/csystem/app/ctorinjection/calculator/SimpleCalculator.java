package org.csystem.app.ctorinjection.calculator;

import org.csystem.app.ctorinjection.operation.IIntBinaryOperation;
import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SimpleCalculator {
    private final Collection<IIntBinaryOperation> m_binaryOperations;

    private void throwException(char op)
    {
        throw new UnsupportedOperationException("Unsupported operation:" + op);
    }

    public SimpleCalculator(Collection<IIntBinaryOperation> binaryOperations)
    {
        m_binaryOperations = binaryOperations;
    }

    public void calculate(int a, int b, char op)
    {
        m_binaryOperations.stream()
                .filter(bo -> bo.isValid(op))
                .findFirst()
                .ifPresentOrElse(bo -> Console.writeLine("%d %c %d = %d", a, op, b, bo.applyAsInt(a, b)), () -> throwException(op));
    }

    public void calculateForAll(int a, int b, char op)
    {
        m_binaryOperations.stream()
                .filter(bo -> bo.isValid(op))
                .forEach(bo ->  Console.writeLine("%d %c %d = %d", a, op, b, bo.applyAsInt(a, b)));
    }
}
