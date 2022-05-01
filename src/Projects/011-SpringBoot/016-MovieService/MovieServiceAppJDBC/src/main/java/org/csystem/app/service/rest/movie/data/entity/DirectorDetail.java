package org.csystem.app.service.rest.movie.data.entity;

import java.time.LocalDate;

public class DirectorDetail {
    private String m_fullName;
    private LocalDate m_birthDate;

    public DirectorDetail(String fullName, LocalDate birthDate)
    {
        m_fullName = fullName;
        m_birthDate = birthDate;
    }

    public String getFullName()
    {
        return m_fullName;
    }

    public void setFullName(String fullName)
    {
        m_fullName = fullName;
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
