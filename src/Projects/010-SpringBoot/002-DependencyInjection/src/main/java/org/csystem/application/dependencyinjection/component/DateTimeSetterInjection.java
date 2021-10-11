package org.csystem.application.dependencyinjection.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeSetterInjection {
    private DateTime m_dateTime;

    @Autowired
    public void setDateTime(DateTime dateTime)
    {
        //...
        m_dateTime = dateTime;
    }

    @PostConstruct
    public void displayDateTime()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("DateTimeSetterInjection:%s", m_dateTime);
        Console.writeLine("--------------------------------------------------------------");
    }
}
