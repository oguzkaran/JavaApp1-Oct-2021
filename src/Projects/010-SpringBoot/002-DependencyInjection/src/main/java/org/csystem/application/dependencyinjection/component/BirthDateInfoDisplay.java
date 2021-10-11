package org.csystem.application.dependencyinjection.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Component
public class BirthDateInfoDisplay {
    private final Temporal m_localDate;
    private final Temporal m_now;

    public BirthDateInfoDisplay(@Qualifier("getBirthDateTemporal") Temporal localDate,
                                @Qualifier("now") Temporal now)
    {
        m_localDate = localDate;
        m_now = now;
    }

    @PostConstruct
    public void displayBirthDate()
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("BirthDateInfoDisplay:%s", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(m_now));
        Console.writeLine(DateTimeFormatter.ofPattern("dd.MM.yyy").format(m_localDate));
        Console.writeLine("--------------------------------------------------------------");
    }
}
