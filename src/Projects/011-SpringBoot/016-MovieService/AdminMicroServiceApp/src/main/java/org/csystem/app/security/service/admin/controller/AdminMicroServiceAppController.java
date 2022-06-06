package org.csystem.app.security.service.admin.controller;

import org.csystem.app.security.service.admin.service.AdminAppService;
import org.csystem.app.security.service.admin.service.dto.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/user/")
public class AdminMicroServiceAppController {
    private final AdminAppService m_appService;

    public AdminMicroServiceAppController(AdminAppService adminAppService) {
        this.m_appService = adminAppService;
    }



    @GetMapping("users/find/year")
    public UsersDTO findByYear(int year)
    {
        return m_appService.getUsersFromServiceByYear(year);
    }

    @GetMapping("users/find/rdate")
    public UsersDTO findByRegisterDate(@RequestParam(value = "d") String registerDate)
    {
        return m_appService.getUsersFromServiceByRegisterDate(LocalDate.parse(registerDate));
    }

    @GetMapping("members/find/enabled")
    public UsersDTO findByEnabled(@RequestParam("e") boolean enabled)
    {
        return m_appService.getUsersFromServiceByEnabled(enabled);
    }


}
