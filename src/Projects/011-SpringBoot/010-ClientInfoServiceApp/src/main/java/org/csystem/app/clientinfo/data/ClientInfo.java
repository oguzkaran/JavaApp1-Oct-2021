package org.csystem.app.clientinfo.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")
public class ClientInfo {
    private final HttpServletRequest m_request;
    private final LocalDateTime m_now;
    private final DateTimeFormatter m_formatter;

    public ClientInfo(HttpServletRequest request, LocalDateTime now, DateTimeFormatter formatter)
    {
        m_request = request;
        m_now = now;
        m_formatter = formatter;
    }

    @Override
    public String toString()
    {
        var localAddr = m_request.getLocalAddr();
        var remoteAddr = m_request.getRemoteAddr();
        var remoteHost = m_request.getRemoteHost();
        var localPort = m_request.getLocalPort();
        var remotePort = m_request.getRemotePort();

        return String.format("%s, %s, %s, %d, %d, %s", localAddr, remoteAddr, remoteHost, localPort, remotePort,
                m_formatter.format(m_now));
    }
}
