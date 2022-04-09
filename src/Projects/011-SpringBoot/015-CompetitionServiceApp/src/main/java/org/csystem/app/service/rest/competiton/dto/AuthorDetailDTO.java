package org.csystem.app.service.rest.competiton.dto;

import java.time.LocalDate;

public class AuthorDetailDTO {
    private String m_email;
    private String m_name;
    private LocalDate m_registerDate;

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        m_email = email;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getRegisterDate()
    {
        return m_registerDate;
    }

    public void setRegisterDate(LocalDate registerDate)
    {
        m_registerDate = registerDate;
    }
}
