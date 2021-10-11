package org.csystem.application.calculator.calculator;

import org.csystem.application.calculator.operation.SampleCalculator;
import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator implements ICalculator {
    private final SampleCalculator m_sampleCalculator;

    @Value("${mycalc.a:0}")
    private int m_a;

    @Value("${mycalc.b:1}")
    private int m_b;

    @Value("${mycalc.op:+}")
    private char m_op;

    public MyCalculator(SampleCalculator sampleCalculator)
    {
        m_sampleCalculator = sampleCalculator;
    }

    @Override
    public void calculate()
    {
        Console.writeLine("MyCalculator");
        m_sampleCalculator.calculate(m_a, m_b, m_op);
    }
}
