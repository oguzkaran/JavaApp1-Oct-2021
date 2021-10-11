package org.csystem.application.service.rest.movie.data.entity;

import java.time.LocalDate;

public class Director {
    private long m_id;
    private String m_name;
    private LocalDate m_birthDate;

    public Director()
    {}

    public Director(String name)
    {
        this(0, name);
    }

    public Director(long id, String name)
    {
        this(id, name, null);
    }

    public Director(long id, String name, LocalDate birthDate)
    {
        m_id = id;
        m_name = name;
        m_birthDate = birthDate;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }
}
