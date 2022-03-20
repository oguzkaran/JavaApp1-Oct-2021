package org.csystem.app.ctorinjection.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CengizCalculatorParameter {
    @Value("${cengiz.parameter.a:1}")
    public int a;

    @Value("${cengiz.parameter.b:1}")
    public int b;

    @Value("${cengiz.parameter.op:*}")
    public char op;

    //...
}
