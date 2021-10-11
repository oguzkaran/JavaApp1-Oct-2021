package org.csystem.application.calculator.calculator;

import org.csystem.application.calculator.operation.SampleCalculator;
import org.csystem.application.calculator.parameter.BeyzaParameterInfo;
import org.csystem.util.Console;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TurgutCalculator implements ICalculator {
    private final SampleCalculator m_calculator;
    private final BeyzaParameterInfo m_parameterInfo;

    public TurgutCalculator(SampleCalculator calculator, BeyzaParameterInfo parameterInfo)
    {
        m_calculator = calculator;
        m_parameterInfo = parameterInfo;
    }

    @Override
    public void calculate()
    {
        Console.writeLine("TurgutCalculator");
        m_calculator.calculateForAll(m_parameterInfo.a, m_parameterInfo.b, m_parameterInfo.op);
    }
}
