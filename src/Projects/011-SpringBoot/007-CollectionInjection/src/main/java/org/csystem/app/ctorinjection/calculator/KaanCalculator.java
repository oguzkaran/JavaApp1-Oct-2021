package org.csystem.app.ctorinjection.calculator;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KaanCalculator implements ICalculator {
    private final SimpleCalculator m_simpleCalculator;

    @Value("${kaan.calculator.a:0}")
    private int m_a;

    @Value("${kaan.calculator.b:0}")
    private int m_b;

    @Value("${kaan.calculator.op:+}")
    private char m_op;

    public KaanCalculator(SimpleCalculator simpleCalculator)
    {
        m_simpleCalculator = simpleCalculator;
    }

    @Override
    public void calculate() throws Exception
    {
        Console.writeLine("Kaan Calculator");
        m_simpleCalculator.calculateForAll(m_a, m_b, m_op);
        Console.writeLine("-------------------------------------");
        m_simpleCalculator.calculate(m_a, m_b, m_op);
    }
}
