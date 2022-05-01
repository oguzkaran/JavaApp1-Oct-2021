package org.csystem.app.security.service.admin.data.dal;

import org.csystem.app.security.service.admin.data.repository.IMemberRepository;
import org.springframework.stereotype.Component;

@Component
public class SystemAdminAppHelper {
    private final IMemberRepository m_memberRepository;

    public SystemAdminAppHelper(IMemberRepository memberRepository)
    {
        m_memberRepository = memberRepository;
    }
}
