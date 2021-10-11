package org.csystem.application.servletrequestinfo.controller;

import org.csystem.application.servletrequestinfo.component.ClientInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/info")
@Scope("prototype")
public class ClientInformationController {
    private final HttpServletRequest m_request;
    private final ClientInfo m_clientInfo;

    public ClientInformationController(HttpServletRequest request, ClientInfo clientInfo)
    {
        m_request = request;
        m_clientInfo = clientInfo;
    }

    @GetMapping("/client") //@RequestMapping(value = "/client", method = RequestMethod.GET)
    public String getClientInfo()
    {
        return m_clientInfo.setLocalAddress(m_request.getLocalAddr())
                .setRemoteAddress(m_request.getRemoteAddr())
                .setRemoteHost(m_request.getRemoteHost())
                .setLocalPort(m_request.getLocalPort())
                .setRemotePort(m_request.getRemotePort())
                .toString();
    }
}
