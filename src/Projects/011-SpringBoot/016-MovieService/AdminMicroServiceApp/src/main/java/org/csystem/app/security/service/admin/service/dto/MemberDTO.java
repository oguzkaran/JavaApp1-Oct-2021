package org.csystem.app.security.service.admin.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class MemberDTO {
    private int m_id;

    private String m_username;

    private String m_password;

    private boolean m_enabled;

    private LocalDate m_registerDate = LocalDate.now();

    private List<MemberRoleDTO> m_roles;


    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }

    public boolean isEnabled()
    {
        return m_enabled;
    }

    public void setEnabled(boolean enabled)
    {
        m_enabled = enabled;
    }

    public LocalDate getRegisterDate()
    {
        return m_registerDate;
    }

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public void setRegisterDate(LocalDate registerDate)
    {
        m_registerDate = registerDate;
    }

    public List<MemberRoleDTO> getRoles()
    {
        return m_roles;
    }

    public void setRoles(List<MemberRoleDTO> roles)
    {
        m_roles = roles;
    }
}
