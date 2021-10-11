package org.csystem.application.servletrequestinfo.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")
public class ClientInfo {
    private String m_localAddress;
    private String m_remoteAddress;
    private String m_remoteHost;
    private int m_localPort;
    private int m_remotePort;
    private final LocalDateTime m_localDateTime = LocalDateTime.now();

    //...

    public String getLocalAddress()
    {
        return m_localAddress;
    }

    public String getRemoteAddress()
    {
        return m_remoteAddress;
    }

    public String getRemoteHost()
    {
        return m_remoteHost;
    }

    public int getLocalPort()
    {
        return m_localPort;
    }

    public int getRemotePort()
    {
        return m_remotePort;
    }

    public LocalDateTime getLocalDateTime()
    {
        return m_localDateTime;
    }

    public ClientInfo setLocalAddress(String localAddress)
    {
        m_localAddress = localAddress;

        return this;
    }

    public ClientInfo setRemoteAddress(String remoteAddress)
    {
        m_remoteAddress = remoteAddress;

        return this;
    }

    public ClientInfo setRemoteHost(String remoteHost)
    {
        m_remoteHost = remoteHost;

        return this;
    }

    public ClientInfo setLocalPort(int localPort)
    {
        m_localPort = localPort;

        return this;
    }

    public ClientInfo setRemotePort(int remotePort)
    {
        m_remotePort = remotePort;

        return this;
    }

    @Override
    public String toString()
    {
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        var formatStr = "Local Addres: %s, Remote Address: %s, Remote Host: %s, Local Port: %d, Remote Port: %d, Request Time:%s";

        return String.format(formatStr, m_localAddress, m_remoteAddress, m_remoteHost,
                m_localPort, m_remotePort, formatter.format(m_localDateTime));
    }
}
