package org.csystem.app.security.service.admin.service;

import org.csystem.app.security.service.admin.service.dto.MembersDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminAppService {
    private final RestTemplate m_restTemplate;

    @Value("${admin.server.url}")
    private String m_url;

    public AdminAppService(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }

    public MembersDTO getAllMembersFromService()
    {
        return m_restTemplate.getForObject(m_url, MembersDTO.class);
    }
}
