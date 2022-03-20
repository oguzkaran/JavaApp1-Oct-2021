package org.csystem.app.ctorinjection.calculator;

import org.csystem.app.ctorinjection.parameter.CengizCalculatorParameter;
import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

@Component("denizCalculator")
public class DenizCalculator implements ICalculator {
    private final CengizCalculatorParameter m_calculatorParameter;
    private final IlkaySimpleCalculator m_calculator;

    public DenizCalculator(CengizCalculatorParameter calculatorParameter, IlkaySimpleCalculator calculator)
    {
        m_calculatorParameter = calculatorParameter;
        m_calculator = calculator;
    }

    @Override
    public void calculate() throws Exception
    {
        Console.writeLine("Deniz Calculator");
        m_calculator.calculate(m_calculatorParameter.a, m_calculatorParameter.b, m_calculatorParameter.op);
    }
}
