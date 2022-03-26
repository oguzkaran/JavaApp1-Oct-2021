package org.csystem.app.greeting.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/greeting")
@Scope("prototype")
public class HelloController {
    private final LocalDateTime m_dateTime;
    private final DateTimeFormatter m_formatter;

    public HelloController(LocalDateTime dateTime, DateTimeFormatter formatter)
    {
        m_dateTime = dateTime;
        m_formatter = formatter;
    }

    @GetMapping("hello/en")
    public String helloEn()
    {
        return "Hello:" + m_formatter.format(m_dateTime);
    }

    @GetMapping("hello/tr")
    public String helloTR()
    {
        return "Merhaba:" +  m_formatter.format(m_dateTime);
    }
}
