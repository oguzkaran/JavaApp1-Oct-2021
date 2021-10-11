package org.csystem.application.dependencyinjection.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeConstructorInjection {
    private final DateTime m_dateTime;

    public DateTimeConstructorInjection(@Qualifier("myDateTime") DateTime dateTime)
    {
        m_dateTime = dateTime;
    }

    @PostConstruct
    public void displayDateTime()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("DateTimeConstructorInjection:%s", m_dateTime);
        Console.writeLine("--------------------------------------------------------------");
    }
}
