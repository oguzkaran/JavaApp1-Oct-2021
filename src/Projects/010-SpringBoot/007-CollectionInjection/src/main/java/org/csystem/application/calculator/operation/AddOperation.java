package org.csystem.application.calculator.operation;

import org.springframework.stereotype.Component;

@Component
public class AddOperation implements IIntBinaryOperator {
    //...
    @Override
    public boolean isValid(char op)
    {
        return op == '+';
    }

    @Override
    public int applyAsInt(int left, int right)
    {
        return left + right;
    }
}
