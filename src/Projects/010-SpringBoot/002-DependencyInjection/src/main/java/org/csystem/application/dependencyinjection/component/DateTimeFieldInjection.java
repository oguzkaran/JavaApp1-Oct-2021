package org.csystem.application.dependencyinjection.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeFieldInjection {
    @Autowired
    private DateTime m_dateTime;

    @PostConstruct
    public void displayDateTime()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("DateTimeFieldInjection:%s", m_dateTime);
        Console.writeLine("--------------------------------------------------------------");
    }
}
