package org.csystem.app.security.service.admin.service.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class UsersDTO {
    private List<UserDTO> m_userDTOS;

    @JsonGetter("users")
    public List<UserDTO> getUserDTOS()
    {
        return m_userDTOS;
    }

    @JsonSetter("members")
    public void setUserDTOS(List<UserDTO> userDTOS)
    {
        m_userDTOS = userDTOS;
    }
}
