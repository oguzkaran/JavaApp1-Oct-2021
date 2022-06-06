package org.csystem.app.security.service.admin.service.dto;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class UserDTO {

    private String username;
    private boolean enabled;
    private String regDate;
    private List<UserRoleDTO> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @JsonGetter("regDate")
    public String getRegDate() {
        return regDate;
    }

    @JsonSetter("registerDate")
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public List<UserRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleDTO> roles) {
        this.roles = roles;
    }
}
