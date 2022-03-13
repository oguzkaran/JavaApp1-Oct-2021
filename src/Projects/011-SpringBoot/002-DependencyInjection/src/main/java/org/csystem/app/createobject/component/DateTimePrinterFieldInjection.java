package org.csystem.app.createobject.component;

import org.csystem.app.createobject.BeanName;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

@Component
public class DateTimePrinterFieldInjection {
    @Autowired
    @Qualifier("dateTimeConfigCreateNow")
    private TemporalAccessor m_localDateTime;

    @Autowired
    @Qualifier(BeanName.DATETIMEFORMATTER_BEAN_NAME)
    private DateTimeFormatter m_formatter;

    @PostConstruct
    public void printDateTime() throws InterruptedException
    {
        Thread.sleep(2000); //Bekletme tamamen durumu göstermek içindir. Normalde bu şekilde bu metotta bekletme iyi bir teknik değildir
        Console.writeLine("DateTimePrinterFieldInjection:Now:%s", m_formatter.format(m_localDateTime));
    }
}
