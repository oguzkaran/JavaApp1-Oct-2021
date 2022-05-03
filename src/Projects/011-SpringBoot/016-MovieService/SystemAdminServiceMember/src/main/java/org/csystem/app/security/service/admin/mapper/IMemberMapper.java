package org.csystem.app.security.service.admin.mapper;


import org.csystem.app.security.service.admin.data.entity.Member;
import org.csystem.app.security.service.admin.dto.MemberDTO;
import org.csystem.app.security.service.admin.dto.MembersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MemberMapperImpl", componentModel = "spring")
public interface IMemberMapper {
    MemberDTO toMemberDTO(Member member);

    default MembersDTO toMembersDTO(List<MemberDTO> memberDTOS)
    {
        var dto = new MembersDTO();

        dto.setMemberDTOS(memberDTOS);

        return dto;
    }
}
