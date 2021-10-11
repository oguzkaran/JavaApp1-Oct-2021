package org.csystem.application.calculator.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeyzaParameterInfo {
    @Value("${bcalc.a:0}")
    public int a;
    @Value("${bcalc.b:1}")
    public int b;
    @Value("${bcalc.op:*}")
    public char op;
}
