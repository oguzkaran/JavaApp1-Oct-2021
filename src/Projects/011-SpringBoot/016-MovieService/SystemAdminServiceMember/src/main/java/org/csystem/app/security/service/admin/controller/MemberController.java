package org.csystem.app.security.service.admin.controller;

import org.csystem.app.security.service.admin.dto.MembersDTO;
import org.csystem.app.security.service.admin.service.SystemAdminAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static org.csystem.util.collection.CollectionUtil.toList;

@RestController
@RequestMapping("api/member")
public class MemberController {
    private final SystemAdminAppService m_systemAdminAppService;

    public MemberController(SystemAdminAppService systemAdminAppService, SystemAdminAppService systemAdminAppService1)
    {
        m_systemAdminAppService = systemAdminAppService;
    }

    @GetMapping("members/all")
    public MembersDTO findAllMembers()
    {
        return m_systemAdminAppService.findAllMembers();
    }

    @GetMapping("members/find/enabled")
    public MembersDTO findByEnabled(@RequestParam("e") boolean enabled)
    {
        return m_systemAdminAppService.findMemberByEnabled(enabled);
    }

    @GetMapping("members/find/rdate")
    public MembersDTO findByRegisterDate(@RequestParam("d") String registerDate)
    {
        return m_systemAdminAppService.findMemberByRegisterDate(LocalDate.parse(registerDate));
    }

    @GetMapping("members/find/year")
    public MembersDTO findByYear(@RequestParam("y") int year)
    {
        return m_systemAdminAppService.findMemberByYear(year);
    }
}
