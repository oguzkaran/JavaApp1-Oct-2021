package org.csystem.app.security.service.admin.service;

import org.csystem.app.security.service.admin.data.dal.SystemAdminAppHelper;
import org.csystem.app.security.service.admin.data.entity.Member;
import org.csystem.app.security.service.admin.dto.MemberDTO;
import org.csystem.app.security.service.admin.dto.MembersDTO;
import org.csystem.app.security.service.admin.mapper.IMemberMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


import static org.csystem.util.collection.CollectionUtil.toList;


@Service
public class SystemAdminAppService {
    private final SystemAdminAppHelper m_adminAppHelper;
    private final IMemberMapper m_memberMapper;

    public SystemAdminAppService(SystemAdminAppHelper adminAppHelper, IMemberMapper memberMapper)
    {
        m_adminAppHelper = adminAppHelper;
        m_memberMapper = memberMapper;
    }

    public MembersDTO findAllMembers()
    {
        return m_memberMapper.toMembersDTO(toList(m_adminAppHelper.findAllMembers(), m_memberMapper::toMemberDTO));
    }

    public MembersDTO findMemberByEnabled(boolean enabled)
    {
        return m_memberMapper.toMembersDTO(toList(m_adminAppHelper.findMemberByEnabled(enabled), m_memberMapper::toMemberDTO));
    }

    public MembersDTO findMemberByRegisterDate(LocalDate registerDate)
    {
        return m_memberMapper.toMembersDTO(toList(m_adminAppHelper.findMemberByRegisterDate(registerDate), m_memberMapper::toMemberDTO));
    }

    public MembersDTO findMemberByYear(int year)
    {
        return m_memberMapper.toMembersDTO(toList(m_adminAppHelper.findMemberByYear(year), m_memberMapper::toMemberDTO));
    }
}
