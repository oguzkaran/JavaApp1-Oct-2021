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
public class DateTimePrinterPropertyInjection {
    private LocalDateTime m_localDateTime;
    private DateTimeFormatter m_formatter;

    @Autowired
    public void setLocalDateTime(LocalDateTime localDateTime)
    {
        m_localDateTime = localDateTime;
    }

    @Autowired
    @Qualifier(BeanName.DATETIMEFORMATTER_BEAN_NAME)
    public void setFormatter(DateTimeFormatter formatter)
    {
        m_formatter = formatter;
    }

    //...

    @PostConstruct
    public void printDateTime() throws InterruptedException
    {
        Console.writeLine("DateTimePrinterPropertyInjection:Now:%s", m_formatter.format(m_localDateTime));
    }
}
