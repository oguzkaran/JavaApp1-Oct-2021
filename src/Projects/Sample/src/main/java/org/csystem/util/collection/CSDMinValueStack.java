package org.csystem.util.collection;

import java.util.OptionalInt;
import java.util.Stack;

public class CSDMinValueStack extends Stack<Integer> {
    private final Stack<Integer> m_minStack = new Stack<>();

    @Override
    public Integer push(Integer val)
    {
        var minOpt = min();

        if (minOpt.isPresent()) {
            var minVal = minOpt.getAsInt();

            if (minVal > val)
                m_minStack.push(val);
        }
        else
            m_minStack.push(val);

        return super.push(val);
    }

    @Override
    public Integer pop()
    {
        int val = super.pop();

        var minOpt = min();

        if (minOpt.isPresent()) {
            var minVal = minOpt.getAsInt();

            if (minVal > val)
                m_minStack.pop();
        }

        return val;
    }

    public OptionalInt min()
    {
        return m_minStack.isEmpty() ? OptionalInt.empty() : OptionalInt.of(m_minStack.peek());
    }

    //...
}
