package org.csystem.app.security.service.admin.service;

import org.csystem.app.security.service.admin.global.UrlInfo;
import org.csystem.app.security.service.admin.service.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminAppService {
    private final RestTemplate m_restTemplate;
    private final UrlInfo m_urlInfo;

    public AdminAppService(RestTemplate restTemplate, UrlInfo urlInfo)
    {
        m_restTemplate = restTemplate;
        m_urlInfo = urlInfo;
    }

    public UsersDTO getUsersFromServiceByYear(int year)
    {
        return m_restTemplate.getForObject(m_urlInfo.findUserByYearUrl + year, UsersDTO.class, year);
    }
    //...
}
