package org.csystem.app.createobject.component;

import org.csystem.app.createobject.BeanName;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Component
public class AgeInfoPrinter {
    private final Temporal m_temporal;
    private final Temporal m_today;
    private final Temporal m_now;
    private final DateTimeFormatter m_formatter;

    public AgeInfoPrinter(
            @Qualifier("birthdateConfigGetBirthDate") Temporal temporal,
            @Qualifier("birthdateConfigGetToday") Temporal today,
            @Qualifier("birthdateConfigGetNow")Temporal now,
            @Qualifier(BeanName.DATETIMEFORMATTER_BEAN_NAME) DateTimeFormatter formatter)
    {
        m_temporal = temporal;
        m_today = today;
        m_now = now;
        m_formatter = formatter;
    }

    @PostConstruct
    public void printBirthDateAndAge() throws InterruptedException
    {
        Console.writeLine("////////////////////////////////////////////////////");
        Console.writeLine("AgeInfoPrinter: %s", m_formatter.format(m_now));
        var age = ChronoUnit.DAYS.between(m_temporal, m_today) / 365.;

        Thread.sleep(2000);
        Console.writeLine("Age:%f", age);
        Console.writeLine("////////////////////////////////////////////////////");
    }
}
