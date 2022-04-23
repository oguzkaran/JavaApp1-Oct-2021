package org.csystem.app.service.rest.movie.data.entity;

import java.time.LocalDate;

public class Director {
    private long m_id;
    private String m_firstName;
    private String m_middleName;
    private String m_familyName;
    private LocalDate m_birthDate;

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public String getMiddleName()
    {
        return m_middleName;
    }

    public void setMiddleName(String middleName)
    {
        m_middleName = middleName;
    }

    public String getFamilyName()
    {
        return m_familyName;
    }

    public void setFamilyName(String familyName)
    {
        m_familyName = familyName;
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
