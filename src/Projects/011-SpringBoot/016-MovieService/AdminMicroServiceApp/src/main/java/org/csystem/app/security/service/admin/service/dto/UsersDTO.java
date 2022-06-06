package org.csystem.app.security.service.admin.service.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class UsersDTO {
    private List<UserDTO> userDTOS;

    @JsonGetter("users")
    public List<UserDTO> getMemberDTOS() {
        return userDTOS;
    }

    @JsonSetter("members")
    public void setMemberDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
}
