package org.csystem.app.service.rest.competiton.dto;

import java.time.LocalDateTime;

public class AuthorDetailDTO {
    private String m_email;
    private String m_name;
    private LocalDateTime m_registerTime;

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

    public LocalDateTime getRegisterTime()
    {
        return m_registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime)
    {
        m_registerTime = registerTime;
    }

}
