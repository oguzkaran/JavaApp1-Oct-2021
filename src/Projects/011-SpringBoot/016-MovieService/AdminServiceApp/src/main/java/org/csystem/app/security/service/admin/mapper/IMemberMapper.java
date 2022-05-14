package org.csystem.app.security.service.admin.mapper;


import org.csystem.app.security.service.admin.data.entity.Member;
import org.csystem.app.security.service.admin.data.entity.MemberRole;
import org.csystem.app.security.service.admin.dto.MemberDTO;
import org.csystem.app.security.service.admin.dto.MemberRoleDTO;
import org.csystem.app.security.service.admin.dto.MembersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "MemberMapperImpl", componentModel = "spring")
public interface IMemberMapper {
    @Mapping(source = "memberRoles", target = "roles")
    MemberDTO toMemberDTO(Member member);

    MemberRoleDTO toMemberRoleDTO(MemberRole memberRole);

    default MembersDTO toMembersDTO(List<MemberDTO> memberDTOS)
    {
        var dto = new MembersDTO();

        dto.setMemberDTOS(memberDTOS);

        return dto;
    }
}
