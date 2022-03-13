package org.csystem.app.createobject.component;

import org.csystem.app.createobject.BeanName;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

@Component
public class TimePrinter {
    private final TemporalAccessor m_temporalAccessor;
    private final DateTimeFormatter m_formatter;

    public TimePrinter(@Qualifier("dateTimeConfigCreateNow") TemporalAccessor temporalAccessor, @Qualifier(BeanName.TIMEFORMATTER_BEAN_NAME) DateTimeFormatter formatter)
    {
        m_temporalAccessor = temporalAccessor;
        m_formatter = formatter;
    }

    @PostConstruct
    public void printDateTime() throws InterruptedException
    {
        Console.writeLine("Now:%s", m_formatter.format(m_temporalAccessor));
    }
}
