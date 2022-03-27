package org.csystem.app.randomgenerator.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class TextInfo { //Sınıf bean olarak yapılmayabilir. Tamamen örnek amaçlı yazılmıştır
    public String text;
    public String lang;
    public LocalDateTime dateTime;

    public TextInfo(String text, String lang, LocalDateTime dateTime)
    {
        this.text = text;
        this.lang = lang;
        this.dateTime = dateTime;
    }

    //...
}
