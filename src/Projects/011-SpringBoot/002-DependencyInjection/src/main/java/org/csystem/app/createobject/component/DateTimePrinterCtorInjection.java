package org.csystem.app.createobject.component;

import org.csystem.app.createobject.BeanName;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimePrinterCtorInjection {
    private final LocalDateTime m_localDateTime;
    private final DateTimeFormatter m_formatter;

    public DateTimePrinterCtorInjection(LocalDateTime localDateTime,
                                        @Qualifier(BeanName.DATETIMEFORMATTER_BEAN_NAME) DateTimeFormatter formatter) //ctor injection
    {
        m_localDateTime = localDateTime;
        m_formatter = formatter;
    }


    @PostConstruct
    public void printDateTime() throws InterruptedException
    {
        Console.writeLine("DateTimePrinterCtorInjection:Now:%s", m_formatter.format(m_localDateTime));
    }
}
