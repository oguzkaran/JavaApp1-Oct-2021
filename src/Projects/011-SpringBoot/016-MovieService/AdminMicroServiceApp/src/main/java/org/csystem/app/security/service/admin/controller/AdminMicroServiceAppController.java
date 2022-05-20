package org.csystem.app.security.service.admin.controller;

import org.csystem.app.security.service.admin.service.AdminAppService;
import org.csystem.app.security.service.admin.service.dto.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/")
public class AdminMicroServiceAppController {
    private final AdminAppService m_appService;

    public AdminMicroServiceAppController(AdminAppService appService)
    {
        m_appService = appService;
    }

    @GetMapping("users/find/year")
    public UsersDTO findByYear(int year)
    {
        return m_appService.getUsersFromServiceByYear(year);
    }
}
