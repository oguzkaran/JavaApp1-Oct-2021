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

    public String getLocalAddress()
    {
        return m_request.getLocalAddr();
    }

    public String getRemoteAddress()
    {
        return m_request.getRemoteAddr();
    }

    public String getRemoteHost()
    {
        return m_request.getRemoteHost();
    }

    public int getLocalPort()
    {
        return m_request.getLocalPort();
    }

    public int getRemotePort()
    {
        return m_request.getRemotePort();
    }

    public LocalDateTime getDateTime()
    {
        return m_now;
    }

    public String getDateTimeStr()
    {
        return m_formatter.format(m_now);
    }
}
