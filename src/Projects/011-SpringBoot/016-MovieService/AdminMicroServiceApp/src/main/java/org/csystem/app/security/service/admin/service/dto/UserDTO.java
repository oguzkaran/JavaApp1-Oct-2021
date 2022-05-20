package org.csystem.app.security.service.admin.service.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class UserDTO {
    private String m_username;

    private boolean m_enabled;

    private String m_regDate;

    private List<UserRoleDTO> m_roles;

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public boolean isEnabled()
    {
        return m_enabled;
    }

    public void setEnabled(boolean enabled)
    {
        m_enabled = enabled;
    }

    @JsonGetter("regDate")
    public String getRegDate()
    {
        return m_regDate;
    }

    @JsonSetter("registerDate")
    public void setRegDate(String regDate)
    {
        m_regDate = regDate;
    }

    public List<UserRoleDTO> getRoles()
    {
        return m_roles;
    }

    public void setRoles(List<UserRoleDTO> roles)
    {
        m_roles = roles;
    }
}
