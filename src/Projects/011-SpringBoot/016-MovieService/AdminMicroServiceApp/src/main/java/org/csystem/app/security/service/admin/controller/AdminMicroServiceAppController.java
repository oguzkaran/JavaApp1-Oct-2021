package org.csystem.app.security.service.admin.controller;

import org.csystem.app.security.service.admin.service.AdminAppService;
import org.csystem.app.security.service.admin.service.dto.MembersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member/")
public class AdminMicroServiceAppController {
    private final AdminAppService m_appService;

    public AdminMicroServiceAppController(AdminAppService appService)
    {
        m_appService = appService;
    }

    @GetMapping("members/all")
    public MembersDTO findAll()
    {
        return m_appService.getAllMembersFromService();
    }
}
