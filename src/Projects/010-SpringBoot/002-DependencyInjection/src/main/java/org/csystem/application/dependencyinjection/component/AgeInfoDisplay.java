package org.csystem.application.dependencyinjection.component;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Component
public class AgeInfoDisplay {
    private final Temporal m_temporal;
    private final Temporal m_today;
    private final Temporal m_now;


    public AgeInfoDisplay(@Qualifier("getBirthDateTemporal") Temporal temporal,
                          @Qualifier("today") Temporal today,
                          @Qualifier("now") Temporal now)
    {
        m_temporal = temporal;
        m_today = today;
        m_now = now;
    }

    @PostConstruct
    public void displayBirthDate() throws InterruptedException
    {
        Console.writeLine("--------------------------------------------------------------");
        Console.writeLine("AgeInfoDisplay:%s", DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(m_now));

        var age = ChronoUnit.DAYS.between(m_temporal, m_today) / 365.;

        Thread.sleep(2000); //Akışı bekletmek için kullanıldı

        Console.writeLine("Age:%f", age);
        Console.writeLine("--------------------------------------------------------------");
    }
}
