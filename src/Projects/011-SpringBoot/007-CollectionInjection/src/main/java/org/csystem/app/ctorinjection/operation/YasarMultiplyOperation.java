package org.csystem.app.ctorinjection.operation;

import org.springframework.stereotype.Component;

@Component
public class YasarMultiplyOperation implements IIntBinaryOperation {
    //...

    @Override
    public boolean isValid(char op)
    {
        return op == '*' || op == 'x';
    }

    @Override
    public int applyAsInt(int left, int right)
    {
        return left * right;
    }
}
