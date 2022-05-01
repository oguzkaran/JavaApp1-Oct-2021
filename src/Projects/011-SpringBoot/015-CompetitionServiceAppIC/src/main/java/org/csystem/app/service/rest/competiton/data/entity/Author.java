package org.csystem.app.service.rest.competiton.data.entity;

import java.time.LocalDate;

public class Author {
    private String m_email;
    private String m_name;
    private LocalDate m_registerDate;

    public Author()
    {

    }

    public Author(String email, String name, LocalDate registerDate)
    {
        this.m_email = email;
        this.m_name = name;
        this.m_registerDate = registerDate;
    }

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        this.m_email = email;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        this.m_name = name;
    }

    public LocalDate getRegisterDate()
    {
        return m_registerDate;
    }

    public void setRegisterDate(LocalDate registerDate)
    {
        this.m_registerDate = registerDate;
    }
}
