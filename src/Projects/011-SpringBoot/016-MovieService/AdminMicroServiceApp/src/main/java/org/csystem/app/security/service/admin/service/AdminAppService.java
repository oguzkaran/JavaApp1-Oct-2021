package org.csystem.app.security.service.admin.service;

import org.csystem.app.security.service.admin.global.UrlInfo;
import org.csystem.app.security.service.admin.service.dto.UserDTO;
import org.csystem.app.security.service.admin.service.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AdminAppService {
    private final RestTemplate m_restTemplate;
    private final UrlInfo m_urlInfo;


    public AdminAppService(RestTemplate restTemplate, UrlInfo urlInfo) {
        this.m_restTemplate = restTemplate;
        this.m_urlInfo = urlInfo;
    }


    public UsersDTO getUsersFromServiceByEnabled(boolean enabled)
    {
        return m_restTemplate.getForObject(m_urlInfo.findUserByEnabledUrl + enabled, UsersDTO.class, enabled);
    }

    public UsersDTO getUsersFromServiceByYear(int year)
    {
        return m_restTemplate.getForObject( m_urlInfo.findUserByYearUrl + year, UsersDTO.class, year);
    }

    public UsersDTO getUsersFromServiceByRegisterDate(LocalDate registerDate)
    {
        return m_restTemplate.getForObject( m_urlInfo.findUserByRegisterDateUrl + registerDate, UsersDTO.class, registerDate);
    }



}
