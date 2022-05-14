package org.csystem.app.security.service.admin.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MembersDTO {
    private List<MemberDTO> m_memberDTOS;

    public List<MemberDTO> getMemberDTOS()
    {
        return m_memberDTOS;
    }

    @JsonProperty("members")
    public void setMemberDTOS(List<MemberDTO> memberDTOS)
    {
        m_memberDTOS = memberDTOS;
    }
}
