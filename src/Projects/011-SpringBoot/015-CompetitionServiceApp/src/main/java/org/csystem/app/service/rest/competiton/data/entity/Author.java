package org.csystem.app.service.rest.competiton.data.entity;

import java.time.LocalDateTime;

public class Author {
    public String email;
    public String name;
    public LocalDateTime registerTime;

    public Author()
    {

    }

    public Author(String email, String name, LocalDateTime registerTime)
    {
        this.email = email;
        this.name = name;
        this.registerTime = registerTime;
    }
    //...
}
