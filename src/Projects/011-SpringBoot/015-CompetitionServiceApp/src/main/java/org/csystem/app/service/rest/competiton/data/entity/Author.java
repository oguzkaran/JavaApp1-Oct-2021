package org.csystem.app.service.rest.competiton.data.entity;

import java.time.LocalDate;

public class Author {
    public String email;
    public String name;
    public LocalDate registerDate;

    public Author()
    {

    }

    public Author(String email, String name, LocalDate registerDate)
    {
        this.email = email;
        this.name = name;
        this.registerDate = registerDate;
    }
    //...
}
